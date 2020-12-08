package com.group.eleventh.travel.entity;

import lombok.Data;

import java.util.Date;

@Data
public class LineType {
    private Integer linetypeid;

    private Integer state;

    private String icon;

    private Date time;

    private String typename;
}
