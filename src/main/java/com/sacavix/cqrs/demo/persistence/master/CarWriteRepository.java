package com.sacavix.cqrs.demo.persistence.master;

import com.sacavix.cqrs.demo.persistence.model.Car;

import java.util.Optional;

public interface CarWriteRepository {
    void save(Car car);
    void update(Car car);
    Optional<Car> findById(Long id);

}
