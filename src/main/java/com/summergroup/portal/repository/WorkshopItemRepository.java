package com.summergroup.portal.repository;

import com.summergroup.portal.domain.WorkshopItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorkshopItemRepository extends JpaRepository<WorkshopItem, Long> {
    Optional<WorkshopItem> findByName(String name);
    Optional<WorkshopItem> findBySteamId(String id);
    Page<WorkshopItem> findAllByTagsIdIn(List<Long> tags, Pageable pageable);
}
