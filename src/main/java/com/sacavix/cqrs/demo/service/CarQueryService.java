package com.sacavix.cqrs.demo.service;

import com.sacavix.cqrs.demo.persistence.replica.dto.CarIdColorDTO;
import com.sacavix.cqrs.demo.persistence.replica.dto.CardBrandColorDTO;
import com.sacavix.cqrs.demo.service.queries.CarsByBrand;
import com.sacavix.cqrs.demo.service.queries.CarsUnderPrice;

import java.util.List;

public interface CarQueryService {
    List<CarIdColorDTO> findAllCarIdColorByBrand(CarsByBrand carsByBrand);
    List<CardBrandColorDTO> findAllCarBrandColorUnderPrice(CarsUnderPrice carsUnderPrice);
}
