package com.family.spring.webmvc.controller;

import javax.validation.Valid;

import com.family.spring.webmvc.vo.Order;

public class TacoController {

    public String processOrder(@Valid Order order) {

        return "success";
    }
}
