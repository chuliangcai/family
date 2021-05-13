package com.family.spring.jpa.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.family.spring.jpa.entity.Coffee;
import com.family.spring.jpa.entity.CoffeeOrder;
import com.family.spring.jpa.repository.CoffeeOrderRepository;
import com.family.spring.jpa.repository.CoffeeRepository;

@Service
public class CoffeeOrderService {

    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;
    @Transactional(rollbackFor = RuntimeException.class)
    public void order(String coffeeName, BigDecimal price, String mobile) {
        Coffee coffee = new Coffee(coffeeName, price);
        coffee = coffeeRepository.save(coffee);
        CoffeeOrder coffeeOrder = new CoffeeOrder(coffee.getId(), mobile);
        coffeeOrderRepository.save(coffeeOrder);
    }
}
