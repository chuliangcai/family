package com.family.spring.r2dbc.dao;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.family.spring.r2dbc.domain.Account;

import reactor.core.publisher.Flux;

public interface AccountDao extends ReactiveCrudRepository<Account, Long> {

    @Query("select * from account c where c.app = :app")
    Flux<Account> findByApp(String app);
}
