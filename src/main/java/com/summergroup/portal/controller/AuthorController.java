package com.summergroup.portal.controller;

import com.summergroup.portal.dto.AuthorDTO;
import com.summergroup.portal.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<Page<AuthorDTO>> getPaginated(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "ASC") String order
    ) {
        return new ResponseEntity<>(authorService.getPaginated(page, size, sort, order), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(authorService.getAuthorById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> create(@RequestBody AuthorDTO authorDTO) {
        return new ResponseEntity<>(authorService.create(authorDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> update(@PathVariable("id") Long id, @RequestBody AuthorDTO authorDTO) {
        return new ResponseEntity<>(authorService.update(authorDTO, id), HttpStatus.OK);
    }

    @PutMapping("/{name}")
    public ResponseEntity<AuthorDTO> update(@PathVariable("name") String name, @RequestBody AuthorDTO authorDTO) {
        return new ResponseEntity<>(authorService.update(authorDTO, name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AuthorDTO> delete(@PathVariable("id") Long id) {
        authorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<AuthorDTO> delete(@PathVariable("name") String name) {
        authorService.delete(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
