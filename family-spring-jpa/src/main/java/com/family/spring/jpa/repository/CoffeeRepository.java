package com.family.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.family.spring.jpa.entity.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
