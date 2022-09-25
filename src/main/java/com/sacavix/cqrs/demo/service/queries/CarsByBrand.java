package com.sacavix.cqrs.demo.service.queries;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarsByBrand {
    private String brand;
}
