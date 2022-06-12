package com.summergroup.portal.mapper;

import com.summergroup.portal.domain.Author;
import com.summergroup.portal.dto.AuthorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorMapper {
    private final ModelMapper modelMapper;
    
    @Autowired
    public AuthorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AuthorDTO toDTO(Author author) {
        return modelMapper.map(author, AuthorDTO.class);
    }

    public Author toEntity(AuthorDTO authorDTO) {
        return modelMapper.map(authorDTO, Author.class);
    }

    public List<AuthorDTO> toDTOList(List<Author> authors) {
        return authors.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<Author> toEntityList(List<AuthorDTO> authorDTOs) {
        return authorDTOs.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
