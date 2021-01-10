package com.family.spring.webflux.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Sex sex;

    private String username;

    private Integer age;
}
