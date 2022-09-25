package com.sacavix.cqrs.demo.controller;

import com.sacavix.cqrs.demo.service.CarCommandService;
import com.sacavix.cqrs.demo.service.commands.CreateCarCommand;
import com.sacavix.cqrs.demo.service.commands.UpdateCarPriceCommand;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
@ConditionalOnProperty(name="car.api.write.enable", havingValue="true")
public class CarCommandController {

    private CarCommandService carCommandService;

    public CarCommandController(CarCommandService carCommandService) {
        this.carCommandService = carCommandService;
    }

    @PostMapping
    public void createCarCommand(@RequestBody  CreateCarCommand createCarCommand) {
        this.carCommandService.handleCreateCarCommand(createCarCommand);
    }

    @PutMapping("/{id}")
    public void updateCarCommand(@PathVariable("id") Long id, @RequestBody UpdateCarPriceCommand updateCarPriceCommand) {
        updateCarPriceCommand.setId(id);
        this.carCommandService.handleUpdateCarPriceCommand(updateCarPriceCommand);
    }

}
