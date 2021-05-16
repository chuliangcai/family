package com.family.spring.jdbc.domain.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Coffee {
    private String id;
    private String name;
    private BigDecimal price;

    public Coffee(String name,BigDecimal price){
        this.name = name;
        this.price=price;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
