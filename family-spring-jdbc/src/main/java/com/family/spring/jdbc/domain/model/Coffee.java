package com.family.spring.jdbc.domain.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Coffee {
    private String name;
    private BigDecimal price;
}
