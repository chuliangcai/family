package com.family.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.family.spring.jpa.entity.CoffeeOrder;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
