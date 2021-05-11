package com.family.spring.webmvc.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;

@Component
@ResponseBody
@RequestMapping
public class StockController {

    @GetMapping("/my-favorites")
    public List<Stock> findMyFavorites(@RequestParam LocalDate birthday) {
        System.out.println(birthday.format(DateTimeFormatter.ISO_DATE));
        return Lists.newArrayList(new Stock("Alphabet Inc", "GOOG"));
    }
}
