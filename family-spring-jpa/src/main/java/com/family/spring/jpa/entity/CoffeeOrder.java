package com.family.spring.jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CoffeeOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long coffeeId;

    private LocalDateTime payTime;

    private String mobile;

    @CreatedDate
    private LocalDateTime created;

    public CoffeeOrder(Long coffeeId, String mobile) {
        this.coffeeId = coffeeId;
        this.mobile = mobile;
        this.payTime = LocalDateTime.now();
    }
}
