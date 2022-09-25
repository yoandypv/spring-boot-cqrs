package com.sacavix.cqrs.demo.persistence.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Car {
    private Long id;
    private String brand;
    private String color;
    private BigDecimal price;
}
