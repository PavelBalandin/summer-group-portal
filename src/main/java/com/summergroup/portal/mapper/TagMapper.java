package com.summergroup.portal.mapper;

import com.summergroup.portal.domain.Tag;
import com.summergroup.portal.dto.TagDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public TagMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TagDTO toDTO(Tag tag) {
        return modelMapper.map(tag, TagDTO.class);
    }

    public Tag toEntity(TagDTO tagDTO) {
        return modelMapper.map(tagDTO, Tag.class);
    }

    public List<TagDTO> toDTOList(List<Tag> tags) {
        return tags.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<Tag> toEntityList(List<TagDTO> tagDTOs) {
        return tagDTOs.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
