package com.group.eleventh.travel.entity;

import lombok.Data;

@Data
public class Order {
    private Integer orderid;

    private String account;

    private Integer lineid;

    private String date;

    private String cusname;

    private String tel;
}
