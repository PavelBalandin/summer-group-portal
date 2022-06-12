package com.summergroup.portal.service;

import com.summergroup.portal.domain.Author;
import com.summergroup.portal.dto.AuthorDTO;
import com.summergroup.portal.exception.ResourceNotFoundException;
import com.summergroup.portal.mapper.AuthorMapper;
import com.summergroup.portal.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public Page<AuthorDTO> getPaginated(int page, int size, String sort, String order) {
        log.info("Getting page with authors");
        Page<Author> authorPage = authorRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(order), sort)));
        return authorPage.map(authorMapper::toDTO);
    }

    public AuthorDTO create(AuthorDTO authorDTO) {
        log.info("Creating author with name: {}", authorDTO.getName());
        Author author = authorRepository.save(authorMapper.toEntity(authorDTO));
        return authorMapper.toDTO(author);
    }

    public AuthorDTO update(AuthorDTO authorDTO, Long id) {
        log.info("Updating author by id: {}", authorDTO.getId());
        Author authorFromDB = authorRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        BeanUtils.copyProperties(authorMapper.toEntity(authorDTO), authorFromDB, "id");
        Author author = authorRepository.save(authorFromDB);
        return authorMapper.toDTO(author);
    }

    public AuthorDTO update(AuthorDTO authorDTO, String name) {
        log.info("Updating author by name: {}", authorDTO.getName());
        Author authorFromDB = authorRepository.findByName(name).orElseThrow(ResourceNotFoundException::new);
        BeanUtils.copyProperties(authorMapper.toEntity(authorDTO), authorFromDB, "id");
        Author author = authorRepository.save(authorFromDB);
        return authorMapper.toDTO(author);
    }

    public void delete(Long id) {
        log.info("Deleting author with id: {}", id);
        Author authorFromDB = authorRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        authorRepository.delete(authorFromDB);
    }

    public void delete(String name) {
        log.info("Deleting author with id: {}", name);
        Author authorFromDB = authorRepository.findByName(name).orElseThrow(ResourceNotFoundException::new);
        authorRepository.delete(authorFromDB);
    }
    
}
