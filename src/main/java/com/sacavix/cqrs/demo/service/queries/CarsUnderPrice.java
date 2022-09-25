package com.sacavix.cqrs.demo.service.queries;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CarsUnderPrice {
    private BigDecimal referencePrice;
}
