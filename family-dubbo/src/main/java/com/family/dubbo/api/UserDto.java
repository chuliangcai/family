package com.family.dubbo.api;

import java.io.Serializable;

public class UserDto implements Serializable {
    private String name;
    private int age;

    public UserDto() {
    }

    public UserDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
