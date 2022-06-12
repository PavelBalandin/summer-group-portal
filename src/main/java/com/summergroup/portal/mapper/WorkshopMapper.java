package com.summergroup.portal.mapper;

import com.summergroup.portal.domain.WorkshopItem;
import com.summergroup.portal.dto.WorkshopItemDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkshopMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public WorkshopMapper(ModelMapper moderMapper) {
        this.modelMapper = moderMapper;
    }

    public WorkshopItemDTO toDTO(WorkshopItem workshopItem) {
        return modelMapper.map(workshopItem, WorkshopItemDTO.class);
    }

    public WorkshopItem toEntity(WorkshopItemDTO workshopItemDTO) {
        return modelMapper.map(workshopItemDTO, WorkshopItem.class);
    }

    public List<WorkshopItemDTO> toDTOList(List<WorkshopItem> workshopItems) {
        return workshopItems.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<WorkshopItem> toEntityList(List<WorkshopItemDTO> workshopItemDTOS) {
        return workshopItemDTOS.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
