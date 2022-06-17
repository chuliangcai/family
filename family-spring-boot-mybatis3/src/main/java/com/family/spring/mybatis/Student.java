package com.family.spring.mybatis;

import lombok.Data;

@Data
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;

    private Teacher teacher;

    private String goodRate;
}
