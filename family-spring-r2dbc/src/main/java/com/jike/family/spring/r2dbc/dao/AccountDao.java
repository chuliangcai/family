package com.jike.family.spring.r2dbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.stereotype.Repository;

import com.jike.family.spring.r2dbc.domain.Account;

import reactor.core.publisher.Flux;

@Repository
public class AccountDao {

    @Autowired
    private R2dbcEntityTemplate r2dbcEntityTemplate;

    /**
     * 查询app 是hermes的账户
     */
    public Flux<Account> search() {
        return r2dbcEntityTemplate
                .select(Account.class)
                .from("account")
                .matching(Query.query(Criteria.where("app").is("hermes")))
                .all();
    }
}
