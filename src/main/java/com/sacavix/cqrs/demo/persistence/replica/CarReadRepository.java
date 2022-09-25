package com.sacavix.cqrs.demo.persistence.replica;

import com.sacavix.cqrs.demo.persistence.replica.dto.CarIdColorDTO;
import com.sacavix.cqrs.demo.persistence.replica.dto.CardBrandColorDTO;

import java.math.BigDecimal;
import java.util.List;

public interface CarReadRepository {
    List<CarIdColorDTO> findAllCarIdColorByBrand(String brand);
    List<CardBrandColorDTO> findAllCarBrandColorUnderPrice(BigDecimal referencePrice);
}
