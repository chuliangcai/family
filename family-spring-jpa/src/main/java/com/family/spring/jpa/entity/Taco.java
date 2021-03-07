package com.family.spring.jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class Taco {

    private LocalDateTime created;

    private LocalDateTime updated;

    @PreUpdate
    public void updatedAt(){
        this.updated = LocalDateTime.now();
    }

    @PrePersist
    public void createAt() {
        this.created = LocalDateTime.now();
    }

}
