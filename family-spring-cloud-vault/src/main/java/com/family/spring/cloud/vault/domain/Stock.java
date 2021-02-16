package com.family.spring.cloud.vault.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 股票名称
     */
    private String name;

    /**
     * 股票代号
     */
    private String symbol;

    /**
     * 国家
     */
    private String country;
}
