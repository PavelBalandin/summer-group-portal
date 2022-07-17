package com.summergroup.portal.service;

import com.summergroup.portal.domain.WorkshopItem;
import com.summergroup.portal.dto.WorkshopItemDTO;
import com.summergroup.portal.exception.ResourceNotFoundException;
import com.summergroup.portal.mapper.WorkshopMapper;
import com.summergroup.portal.repository.WorkshopItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class WorkshopItemService {
    private final WorkshopMapper workshopMapper;
    private final WorkshopItemRepository workshopItemRepository;
    private final TagService tagService;
    private final AuthorService authorService;

    public WorkshopItemService(WorkshopMapper workshopMapper, WorkshopItemRepository workshopItemRepository, TagService tagService, AuthorService authorService) {
        this.workshopMapper = workshopMapper;
        this.workshopItemRepository = workshopItemRepository;
        this.tagService = tagService;
        this.authorService = authorService;
    }

    public Page<WorkshopItemDTO> getPaginated(int page, int size, String sort, String order) {
        log.info("Getting page with items");
        Page<WorkshopItem> itemPage = workshopItemRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(order), sort)));
        return itemPage.map(workshopMapper::toDTO);
    }

    public Page<WorkshopItemDTO> getPaginatedByTags(List<Long> tags, int page, int size, String sort, String order) {
        log.info("Getting page with items by tags");
        Page<WorkshopItem> itemPage = workshopItemRepository.findAllByTagsIdIn(tags, PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(order), sort)));
        return itemPage.map(workshopMapper::toDTO);
    }

    public Page<WorkshopItemDTO> getPaginatedBySimilarName(String name, int page, int size, String sort, String order) {
        log.info("Getting page with items by tags");
        Page<WorkshopItem> itemPage = workshopItemRepository.findByNameIgnoreCaseContaining(name, PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(order), sort)));
        return itemPage.map(workshopMapper::toDTO);
    }

    public WorkshopItemDTO getById(Long id) {
        log.info("Getting workshopItem by Id");
        WorkshopItem workshopItem = workshopItemRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return workshopMapper.toDTO(workshopItem);
    }

    public WorkshopItemDTO getBySteamId(String id) {
        log.info("Getting workshopItem by Id");
        WorkshopItem workshopItem = workshopItemRepository.findBySteamId(id).orElseThrow(ResourceNotFoundException::new);
        return workshopMapper.toDTO(workshopItem);
    }

    public WorkshopItemDTO create(WorkshopItemDTO workshopItemDTO) {
        log.info("Creating item with name: {}", workshopItemDTO.getName());
        WorkshopItem workshopItem = workshopItemRepository.save(workshopMapper.toEntity(workshopItemDTO));
        return workshopMapper.toDTO(workshopItem);
    }

    public WorkshopItemDTO update(WorkshopItemDTO workshopItemDTO, Long id) {
        log.info("Updating item by id: {}", workshopItemDTO.getId());
        WorkshopItem workshopItemFromDB = workshopItemRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        BeanUtils.copyProperties(workshopMapper.toEntity(workshopItemDTO), workshopItemFromDB, "id");
        WorkshopItem workshopItem = workshopItemRepository.save(workshopItemFromDB);
        return workshopMapper.toDTO(workshopItem);
    }

    public WorkshopItemDTO update(WorkshopItemDTO workshopItemDTO, String name) {
        log.info("Updating item by name: {}", workshopItemDTO.getName());
        WorkshopItem workshopItemFromDB = workshopItemRepository.findByName(name).orElseThrow(ResourceNotFoundException::new);
        BeanUtils.copyProperties(workshopMapper.toEntity(workshopItemDTO), workshopItemFromDB, "id");
        WorkshopItem workshopItem = workshopItemRepository.save(workshopItemFromDB);
        return workshopMapper.toDTO(workshopItem);
    }

    public void delete(Long id) {
        log.info("Deleting item with id: {}", id);
        WorkshopItem workshopItemFromDB = workshopItemRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        workshopItemRepository.delete(workshopItemFromDB);
    }

    public void delete(String name) {
        log.info("Deleting item with id: {}", name);
        WorkshopItem workshopItemFromDB = workshopItemRepository.findByName(name).orElseThrow(ResourceNotFoundException::new);
        workshopItemRepository.delete(workshopItemFromDB);
    }
}
