package com.jike.family.spring.devtools.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trade")
public class TradeController {

    @GetMapping
    public String findTradeById() {
        return "find by trade id";
    }
}