package com.jike.family.spring.webflux.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jike.family.spring.webflux.model.Sex;
import com.jike.family.spring.webflux.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping
    public Mono<User> finOne() {
        return Mono.just(User.builder().sex(Sex.MALE).username("zhangsan").build());
    }

    @GetMapping("/all")
    public Flux<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(User.builder().sex(Sex.MALE).username("zhangsan").build());
        users.add(User.builder().sex(Sex.FEMALE).username("lisi").build());
        return Flux.fromIterable(users);
    }
}
