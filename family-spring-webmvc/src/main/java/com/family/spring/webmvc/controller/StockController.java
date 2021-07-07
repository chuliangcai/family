package com.family.spring.webmvc.controller;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;

@Component
@ResponseBody
@RequestMapping
public class StockController {

    @GetMapping("/my-favorites")
    public List<Stock> findMyFavorites() {
        return Lists.newArrayList(new Stock("Alphabet Inc", "GOOG"));
    }

    @PostMapping("/new-stock")
    public void saveStock(@RequestBody Stock stock) {
        System.out.println("保存stock");
    }
}
