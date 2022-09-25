package com.sacavix.cqrs.demo.service.commands;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateCarCommand {
    private String brand;
    private String color;
    private BigDecimal price;
}
