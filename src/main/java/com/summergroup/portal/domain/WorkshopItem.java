package com.summergroup.portal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "workshop_items")
public class WorkshopItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String steamId;
    private String name;
    private String url;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String previewImage;
    @ElementCollection
    @Column(name = "image_name")
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
    @ManyToMany(mappedBy = "workshopItems")
    private Set<Author> authors;
    @ManyToMany(mappedBy = "workshopItems")
    private Set<Tag> tags;
}
