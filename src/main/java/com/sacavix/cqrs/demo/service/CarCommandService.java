package com.sacavix.cqrs.demo.service;

import com.sacavix.cqrs.demo.service.commands.CreateCarCommand;
import com.sacavix.cqrs.demo.service.commands.UpdateCarPriceCommand;

public interface CarCommandService {
    void handleCreateCarCommand(CreateCarCommand createCarCommand);
    void handleUpdateCarPriceCommand(UpdateCarPriceCommand updateCarPriceCommand);
}
