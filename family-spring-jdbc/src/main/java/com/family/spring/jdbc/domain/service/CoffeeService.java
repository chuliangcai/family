package com.family.spring.jdbc.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.family.spring.jdbc.domain.model.Coffee;
import com.family.spring.jdbc.domain.repository.CoffeeRepository;

@Service
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Transactional(rollbackFor = RuntimeException.class)
    public void save(Coffee coffee1, Coffee coffee2) {
        coffeeRepository.save(coffee1);
        System.out.println(coffeeRepository.findAll());
        coffeeRepository.save(coffee2);
        System.out.println(coffeeRepository.findAll());
        throw new RuntimeException("挂了");
    }
}
