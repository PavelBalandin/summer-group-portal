package com.summergroup.portal.controller;

import com.summergroup.portal.dto.TagDTO;
import com.summergroup.portal.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/tags")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public ResponseEntity<Page<TagDTO>> getPaginated(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "ASC") String order
    ) {
        return new ResponseEntity<>(tagService.getPaginated(page, size, sort, order), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TagDTO> create(@RequestBody TagDTO tagDTO) {
        return new ResponseEntity<>(tagService.create(tagDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagDTO> update(@PathVariable("id") Long id, @RequestBody TagDTO tagDTO) {
        return new ResponseEntity<>(tagService.update(tagDTO, id), HttpStatus.OK);
    }

    @PutMapping("/{name}")
    public ResponseEntity<TagDTO> update(@PathVariable("name") String name, @RequestBody TagDTO tagDTO) {
        return new ResponseEntity<>(tagService.update(tagDTO, name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TagDTO> delete(@PathVariable("id") Long id) {
        tagService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<TagDTO> delete(@PathVariable("name") String name) {
        tagService.delete(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
