package com.sacavix.cqrs.demo.persistence.database;

import lombok.Getter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Getter
public class InMemoryDB<K, T> implements InitializingBean {

    private Map<K, T> store;

    @Override
    public void afterPropertiesSet()  {
        store = new ConcurrentHashMap<>();
    }
}
