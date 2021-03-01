package com.data_analysis.analysis.entity;


import lombok.Data;

@Data//相当于提供了get set等方法 equals()、hashCode()、toString()
public class ApiResult {
    private String responseCode;
    private String description;
    private Object data;


}
