package com.group.eleventh.travel.bean;

import lombok.Data;

/**
 * 返回前端信息
 * @param
 */
@Data
public class Result {
    private String msg;
    private boolean success;
    private String detail;
}
