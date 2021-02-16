package com.family.spring.cloud.vault.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.family.spring.cloud.vault.domain.Stock;

public interface StockDao extends JpaRepository<Stock, Long> {
}
