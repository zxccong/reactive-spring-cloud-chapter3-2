package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zxccong
 * @date 2022/3/18
 */
@Data
@AllArgsConstructor
public class Person {

    private String id;
    private Float price;
    private String productCode;
    private String productName;
    private String Description;
}
