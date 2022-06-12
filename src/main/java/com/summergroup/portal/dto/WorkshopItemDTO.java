package com.summergroup.portal.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
public class WorkshopItemDTO {
    private Long id;
    private String name;
    private String url;
    private String description;
    private String previewImage;
    private List<String> additionalImages;
    private long ratingInStar;
    private long rating;
    private BigDecimal size;
    private LocalDateTime posted;
    private LocalDateTime updated;
    private long visitors;
    private long subscribers;
    private long favorites;
    private long comments;
    private long discussions;
    private long changes;
    private Set<AuthorDTO> authors;
    private Set<TagDTO> tags;
}
