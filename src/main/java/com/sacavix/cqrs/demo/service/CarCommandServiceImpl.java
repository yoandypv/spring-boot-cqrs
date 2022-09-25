package com.sacavix.cqrs.demo.service;

import com.sacavix.cqrs.demo.persistence.model.Car;
import com.sacavix.cqrs.demo.persistence.master.CarWriteRepository;
import com.sacavix.cqrs.demo.service.commands.CreateCarCommand;
import com.sacavix.cqrs.demo.service.commands.UpdateCarPriceCommand;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class CarCommandServiceImpl implements CarCommandService, InitializingBean {

    public CarWriteRepository carWriteRepository;

    public Long idGenerator;

    @Override
    public void afterPropertiesSet() {
        this.idGenerator = 0L;
    }

    public CarCommandServiceImpl(CarWriteRepository carWriteRepository) {
        this.carWriteRepository = carWriteRepository;
    }

    @Override
    public void handleCreateCarCommand(CreateCarCommand createCarCommand) {
        Car car = new Car();
        car.setId(++idGenerator);
        car.setColor(createCarCommand.getColor());
        car.setPrice(createCarCommand.getPrice());
        car.setBrand(createCarCommand.getBrand());
        this.carWriteRepository.save(car);
    }

    @Override
    public void handleUpdateCarPriceCommand(UpdateCarPriceCommand updateCarPriceCommand) {
      this.carWriteRepository.findById(updateCarPriceCommand.getId())
              .ifPresent(
               c -> {
                   c.setPrice(updateCarPriceCommand.getPrice());
                   this.carWriteRepository.update(c);
               });
    }

}
