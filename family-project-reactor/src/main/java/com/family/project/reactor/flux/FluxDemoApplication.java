package com.family.project.reactor.flux;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.family.project.reactor.ReactorDemoApplication;
import com.google.common.collect.Lists;

import lombok.Data;
import reactor.core.publisher.Flux;

public class FluxDemoApplication {
    public static void main(String[] args) {
        //        testCreateFlux();
        testCombine();
    }

    /**
     * 创建flux
     */
    public static void testCreateFlux() {
        //从已知序列创建flux
        Flux flux1 = Flux.just("a", "b");
        Flux.fromIterable(Lists.newArrayList("a", "b"));
        Flux.fromArray(new String[]{"a", "b"});
        Flux.range(1, 10);

        //来自Publisher
        Flux.from(flux1);
        //最简单的flux
        Flux flux2 = Flux.from(s -> System.out.println("do subscribe"));
        flux2.subscribe();

        //如何构建一个空的Flux:FluxEmpty
        Flux.empty();

        //Flux.concat()

        //Flux.combineLatest()
        //<image src="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/doc-files/marbles/fromForFlux.svg"/>
        //Flux.from(Publisher)

        //zip
        //merge
        //using try-with-resource
    }

    /**
     * 编程的方式创建flux
     */
    public static void testProgrammaticallyCreateFlux() {
        //generate
        //create
        //push
    }

    /**
     * FluxOperator
     */
    public static void testFluxOperator() {

    }

    public static void testCombine() {
        Flux<Trade> flux = Flux.fromIterable(Lists.newArrayList(
                new Trade(3L, 1L, BigDecimal.valueOf(10)),
                new Trade(1L, 1L, BigDecimal.valueOf(10)),
                new Trade(2L, 2L, BigDecimal.valueOf(100))));
        Flux<User> flux2 = Flux.fromIterable(Lists.newArrayList(new User(1L, "lisi"), new User(2L, "lisi2")));
        Flux<TradeVo> flux1 = Flux.combineLatest(flux, flux2, (TradeVo::new));
        flux1.subscribe(tradeVo -> {
            System.out.println("ww");
        });
    }

    @Data
    private static class User {
        private Long id;
        private String name;

        public User(Long id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    @Data
    private static class Trade {
        private Long userId;
        private Long id;
        private BigDecimal payment;

        public Trade(Long userId, Long id, BigDecimal payment) {
            this.id = id;
            this.userId = userId;
            this.payment = payment;
        }
    }

    @Data
    private static class TradeVo {
        private Long id;
        private BigDecimal payment;
        private String username;

        public TradeVo(Trade trade, User user) {
            this.id = trade.getId();
            this.payment = trade.getPayment();
            this.username = user.getName();
        }
    }
}
