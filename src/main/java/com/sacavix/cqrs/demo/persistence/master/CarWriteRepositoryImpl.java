package com.sacavix.cqrs.demo.persistence.master;

import com.sacavix.cqrs.demo.persistence.database.InMemoryDB;
import com.sacavix.cqrs.demo.persistence.model.Car;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CarWriteRepositoryImpl implements CarWriteRepository {

    // Simulando el master o base de datos de escritura.
    public InMemoryDB<Long, Car> masterDb;

    public CarWriteRepositoryImpl(InMemoryDB<Long, Car> masterDb) {
        this.masterDb = masterDb;
    }

    @Override
    public void save(Car car) {
        this.masterDb.getStore().put(car.getId(), car);
    }

    @Override
    public void update(Car car) {
        this.save(car);
    }

    @Override
    public Optional<Car> findById(Long id) {
        return Optional.ofNullable(this.masterDb.getStore().get(id));
    }
}
