package com.summergroup.portal.service;

import com.summergroup.portal.domain.Tag;
import com.summergroup.portal.dto.TagDTO;
import com.summergroup.portal.exception.ResourceNotFoundException;
import com.summergroup.portal.mapper.TagMapper;
import com.summergroup.portal.repository.TagRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TagService {
    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    public TagService(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    public Page<TagDTO> getPaginated(int page, int size, String sort, String order) {
        log.info("Getting page with tags");
        Page<Tag> tagPage = tagRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(order), sort)));
        return tagPage.map(tagMapper::toDTO);
    }

    public TagDTO create(TagDTO tagDTO) {
        log.info("Creating tag with name: {}", tagDTO.getName());
        Tag tag = tagRepository.save(tagMapper.toEntity(tagDTO));
        return tagMapper.toDTO(tag);
    }

    public TagDTO update(TagDTO tagDTO, Long id) {
        log.info("Updating tag by id: {}", tagDTO.getId());
        Tag tagFromDB = tagRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        BeanUtils.copyProperties(tagMapper.toEntity(tagDTO), tagFromDB, "id");
        Tag tag = tagRepository.save(tagFromDB);
        return tagMapper.toDTO(tag);
    }

    public TagDTO update(TagDTO tagDTO, String name) {
        log.info("Updating tag by name: {}", tagDTO.getName());
        Tag tagFromDB = tagRepository.findByName(name).orElseThrow(ResourceNotFoundException::new);
        BeanUtils.copyProperties(tagMapper.toEntity(tagDTO), tagFromDB, "id");
        Tag tag = tagRepository.save(tagFromDB);
        return tagMapper.toDTO(tag);
    }

    public void delete(Long id) {
        log.info("Deleting tag with id: {}", id);
        Tag tagFromDB = tagRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        tagRepository.delete(tagFromDB);
    }

    public void delete(String name) {
        log.info("Deleting tag with id: {}", name);
        Tag tagFromDB = tagRepository.findByName(name).orElseThrow(ResourceNotFoundException::new);
        tagRepository.delete(tagFromDB);
    }
}
