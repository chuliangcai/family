package com.family.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.family.spring.jpa.entity.SingleTable;

public interface SingleTableRepository extends JpaRepository<SingleTable, Long> {
}
