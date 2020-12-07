package com.group.eleventh.travel.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
    private Integer customerID;
    private String account;
    private String name;
    private String password;
    private Integer age;
    private String gender;
    private String identityID;
    private String tel;
    private int type;
    private String state;

    public Customer(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
