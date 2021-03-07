package com.family.spring.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.family.spring.jpa.entity.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {

    Taco findTopByNameIgnoresCase(String name);

}
