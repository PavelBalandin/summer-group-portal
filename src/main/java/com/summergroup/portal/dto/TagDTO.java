package com.summergroup.portal.dto;

import lombok.Data;

import java.util.List;

@Data
public class TagDTO {
    private Long id;
    private String name;
    private String color;
    private String type;
    private String description;
    private List<String> similarNames;
    private boolean selected;
}
