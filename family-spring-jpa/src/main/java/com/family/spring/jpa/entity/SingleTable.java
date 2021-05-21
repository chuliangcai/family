package com.family.spring.jpa.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SingleTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String key1;

    private Integer key2;

    private String key3;

    private String keyPart1;

    private String keyPart2;

    private String keyPart3;

    private String commonField;
}
