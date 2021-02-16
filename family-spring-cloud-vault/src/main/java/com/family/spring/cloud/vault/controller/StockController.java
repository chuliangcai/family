package com.family.spring.cloud.vault.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.family.spring.cloud.vault.dao.StockDao;
import com.family.spring.cloud.vault.domain.Stock;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockDao stockDao;

    @GetMapping("/most-actives")
    public List<Stock> findMostActives() {
        return stockDao.findAll();
    }
}
