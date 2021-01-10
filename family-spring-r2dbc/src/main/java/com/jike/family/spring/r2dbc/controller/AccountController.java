package com.jike.family.spring.r2dbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jike.family.spring.r2dbc.dao.AccountDao;
import com.jike.family.spring.r2dbc.domain.Account;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountDao accountDao;

    @GetMapping
    public Flux<Account> search(String app) {
        return accountDao.findByApp(app);
    }
}
