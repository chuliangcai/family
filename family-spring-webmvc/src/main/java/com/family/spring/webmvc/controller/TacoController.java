package com.family.spring.webmvc.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.family.spring.webmvc.vo.Order;

public class TacoController {

    public String processOrder(@Valid Order order) {

        return "success";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/login")
    public String login2() {
        return "login";
    }
}
