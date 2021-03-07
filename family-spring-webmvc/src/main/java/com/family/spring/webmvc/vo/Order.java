package com.family.spring.webmvc.vo;

import javax.validation.constraints.NotBlank;

public class Order {


    @NotBlank
    private String name;
    private String email;
}
