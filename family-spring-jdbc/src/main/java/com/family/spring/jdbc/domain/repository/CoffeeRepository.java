package com.family.spring.jdbc.domain.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.family.spring.jdbc.domain.model.Coffee;

@Repository
public class CoffeeRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void save(Coffee coffee) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", coffee.getName());
        params.put("price", coffee.getPrice());
        jdbcTemplate.update("insert into coffee(name,price) values(:name,:price)", params);
    }
}
