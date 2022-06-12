package com.summergroup.portal.controller;

import com.summergroup.portal.dto.WorkshopItemDTO;
import com.summergroup.portal.service.WorkshopItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/workshop-items")
public class WorkshopItemController {
    private final WorkshopItemService workshopItemService;

    public WorkshopItemController(WorkshopItemService workshopItemService) {
        this.workshopItemService = workshopItemService;
    }

    @GetMapping
    public ResponseEntity<Page<WorkshopItemDTO>> getPaginated(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "ASC") String order
    ) {
        return new ResponseEntity<>(workshopItemService.getPaginated(page, size, sort, order), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WorkshopItemDTO> create(@RequestBody WorkshopItemDTO workshopItemDTO) {
        return new ResponseEntity<>(workshopItemService.create(workshopItemDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkshopItemDTO> update(@PathVariable("id") Long id, @RequestBody WorkshopItemDTO workshopItemDTO) {
        return new ResponseEntity<>(workshopItemService.update(workshopItemDTO, id), HttpStatus.OK);
    }

    @PutMapping("/{name}")
    public ResponseEntity<WorkshopItemDTO> update(@PathVariable("name") String name, @RequestBody WorkshopItemDTO workshopItemDTO) {
        return new ResponseEntity<>(workshopItemService.update(workshopItemDTO, name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WorkshopItemDTO> delete(@PathVariable("id") Long id) {
        workshopItemService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<WorkshopItemDTO> delete(@PathVariable("name") String name) {
        workshopItemService.delete(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
