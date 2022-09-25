package com.sacavix.cqrs.demo.controller;

import com.sacavix.cqrs.demo.persistence.replica.dto.CarIdColorDTO;
import com.sacavix.cqrs.demo.persistence.replica.dto.CardBrandColorDTO;
import com.sacavix.cqrs.demo.service.CarQueryService;
import com.sacavix.cqrs.demo.service.queries.CarsByBrand;
import com.sacavix.cqrs.demo.service.queries.CarsUnderPrice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarQueryController {

    private CarQueryService carQueryService;

    public CarQueryController(CarQueryService carQueryService) {
        this.carQueryService = carQueryService;
    }

    @GetMapping("/brand/{brand}")
    public List<CarIdColorDTO> retrieveCardByBrandQuery(@PathVariable String brand) {
        return this.carQueryService
                .findAllCarIdColorByBrand(new CarsByBrand(brand));
    }

    @GetMapping("/price-under/{referencePrice}/")
    public List<CardBrandColorDTO> retrieveCardUnderPriceQuery(@PathVariable BigDecimal referencePrice) {
        return this.carQueryService
                .findAllCarBrandColorUnderPrice(new CarsUnderPrice(referencePrice));
    }
}
