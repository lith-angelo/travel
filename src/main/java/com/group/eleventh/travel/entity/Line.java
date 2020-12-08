package com.group.eleventh.travel.entity;

import lombok.Data;

@Data
public class Line {
    private Integer lineid;

    private Integer linetypeid;

    private String linename;

    private Integer days;

    private Double price;

    private String vehicle;

    private String introduction;

    private String name;
}
