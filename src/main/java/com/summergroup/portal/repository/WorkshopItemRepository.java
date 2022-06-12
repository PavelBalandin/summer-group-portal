package com.summergroup.portal.repository;

import com.summergroup.portal.domain.WorkshopItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkshopItemRepository extends JpaRepository<WorkshopItem, Long> {
    Optional<WorkshopItem> findByName(String name);
}
