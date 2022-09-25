package com.sacavix.cqrs.demo.service;

import com.sacavix.cqrs.demo.persistence.replica.CarReadRepository;
import com.sacavix.cqrs.demo.persistence.replica.dto.CarIdColorDTO;
import com.sacavix.cqrs.demo.persistence.replica.dto.CardBrandColorDTO;
import com.sacavix.cqrs.demo.service.queries.CarsByBrand;
import com.sacavix.cqrs.demo.service.queries.CarsUnderPrice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarQueryServiceImpl implements CarQueryService {

    private final CarReadRepository carReadRepository;

    public CarQueryServiceImpl(CarReadRepository carReadRepository) {
        this.carReadRepository = carReadRepository;
    }

    @Override
    public List<CarIdColorDTO> findAllCarIdColorByBrand(CarsByBrand carsByBrand) {
        return this.carReadRepository
                .findAllCarIdColorByBrand(carsByBrand.getBrand());
    }

    @Override
    public List<CardBrandColorDTO> findAllCarBrandColorUnderPrice(CarsUnderPrice carsUnderPrice) {
        return this.carReadRepository
                .findAllCarBrandColorUnderPrice(carsUnderPrice.getReferencePrice());
    }
}
