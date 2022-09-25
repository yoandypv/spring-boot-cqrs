package com.sacavix.cqrs.demo.persistence.replica;

import com.sacavix.cqrs.demo.persistence.database.InMemoryDB;
import com.sacavix.cqrs.demo.persistence.model.Car;
import com.sacavix.cqrs.demo.persistence.replica.dto.CarIdColorDTO;
import com.sacavix.cqrs.demo.persistence.replica.dto.CardBrandColorDTO;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarReadRepositoryImpl implements CarReadRepository {

    // Conexion simulada a la "replica", una base solo para lecturas
    private InMemoryDB<Long, Car> replicaDb;

    public CarReadRepositoryImpl(InMemoryDB<Long, Car> replicaDb) {
        this.replicaDb = replicaDb;
    }

    // En un proyecto real estas queries son proyecciones, aprende mas https://youtu.be/64CjU6xNdx4
    @Override
    public List<CarIdColorDTO> findAllCarIdColorByBrand(String brand) {
       return this.replicaDb.getStore()
                .entrySet()
                .stream()
                .map(m->m.getValue())
                .filter(c-> brand.equals(c.getBrand()))
                .map(m -> new CarIdColorDTO(m.getId(), m.getColor()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CardBrandColorDTO> findAllCarBrandColorUnderPrice(BigDecimal referencePrice) {
       return this.replicaDb.getStore()
                .entrySet()
                .stream()
                .map(m->m.getValue())
                .filter(c-> referencePrice.compareTo(c.getPrice()) < 0)
                .map(m -> new CardBrandColorDTO(m.getBrand(), m.getColor()))
                .collect(Collectors.toList());
    }
}
