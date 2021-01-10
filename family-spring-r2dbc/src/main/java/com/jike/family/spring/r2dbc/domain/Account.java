package com.jike.family.spring.r2dbc.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Account {

    @Id
    private Long id;

    private String name;

    private String address;

    private String app;
}
