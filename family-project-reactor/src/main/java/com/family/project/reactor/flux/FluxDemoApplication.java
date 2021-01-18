package com.family.project.reactor.flux;

import java.math.BigDecimal;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import lombok.Data;
import lombok.SneakyThrows;
import reactor.core.publisher.Flux;

public class FluxDemoApplication {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    private static String toJson(Object e) {
        return objectMapper.writeValueAsString(e);
    }

    public static void main(String[] args) {
        //testCreateFlux();
        //testCombine();
        testConcat();
        //testFromIterable();
        //testFluxArray();
        //testFluxEmpty
        //testFluxRange
    }

    /**
     * 创建flux
     */
    public static void testCreateFlux() {

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

    public static void testFluxEmpty() {
        //见 FluxEmpty
        Flux.empty();
    }

    public static void testFluxRange() {
        //见 FluxRange
        Flux flux00 = Flux.range(1, 10);
    }

    public static void testFluxArray() {
        //见 FluxArray
        Flux flux1 = Flux.just("a", "b");
        Flux flux2 = Flux.fromArray(new String[]{"c", "d"});
        flux1.subscribe((item) -> {
            System.out.println(toJson(item));
        });
        flux2.subscribe((item) -> {
            System.out.println(toJson(item));
        });
    }

    public static void testFromIterable() {
        //见 FluxIterable
        Flux<Trade> flux = Flux.fromIterable(Lists.newArrayList(
                new Trade(3L, 1L, BigDecimal.valueOf(10)),
                new Trade(1L, 1L, BigDecimal.valueOf(10)),
                new Trade(2L, 2L, BigDecimal.valueOf(100))));
        flux.subscribe((trade) -> {
            System.out.println(toJson(trade));
        });
        flux.subscribe(new Subscriber<Trade>() {
            @Override
            public void onSubscribe(Subscription s) {
                //s.request(Long.MAX_VALUE);请求发布者发布事件
                System.out.println("on subscribe");
            }

            @Override
            public void onNext(Trade trade) {
                System.out.println("on next");
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("on error");
            }

            @Override
            public void onComplete() {
                System.out.println("on complete");
            }
        });
    }

    public static void testCombine() {
        Flux<Trade> flux = Flux.fromIterable(Lists.newArrayList(
                new Trade(1L, 1L, BigDecimal.valueOf(10)),
                new Trade(1L, 2L, BigDecimal.valueOf(11)),
                new Trade(2L, 3L, BigDecimal.valueOf(12))));

        Flux<User> flux2 = Flux.fromIterable(Lists.newArrayList(new User(1L, "lisi"), new User(2L, "lisi2")));

        Flux<Order> flux3 = Flux.fromIterable(Lists.newArrayList(
                new Order(3L, 4L, 13),
                new Order(1L, 5L, 14),
                new Order(2L, 6L, 15)));

        //见 FluxCombineLatest
        Flux<TradeVo> flux1 = Flux.combineLatest((objs) -> new TradeVo((Trade) objs[0], (User) objs[1], (Order) objs[2]), flux, flux2, flux3);
        flux1.subscribe((vo) -> {
            System.out.println(toJson(vo));
        });
    }

    public static void testConcat() {
        //流水线拼接
        Flux<User> flux1 = Flux.fromIterable(Lists.newArrayList(new User(1L, "lisi"), new User(2L, "lisi2")));
        Flux<User> flux2 = Flux.fromIterable(Lists.newArrayList(new User(3L, "lisi"), new User(4L, "lisi2")));
        //见 FluxConcatArray
        Flux<User> flux3 = Flux.concat(flux1, flux2);
        flux3.subscribe((v) -> {
            System.out.println(toJson(v));
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
    private static class Order {
        private Long id;
        private Long tid;
        private int price;

        public Order(Long id, Long tid, int price) {
            this.id = id;
            this.tid = tid;
            this.price = price;
        }
    }

    @Data
    private static class Trade {
        private Long userId;
        private Long id;
        private BigDecimal payment;

        public Trade(Long userId, Long id, BigDecimal payment) {
            this.userId = userId;
            this.id = id;
            this.payment = payment;
        }
    }

    @Data
    private static class TradeVo {
        private Long id;
        private BigDecimal payment;
        private String username;
        private int price;

        public TradeVo(Trade trade, User user, Order order) {
            System.out.println("combine trade:" + toJson(trade) + " user:" + toJson(user));
            this.id = trade.getId();
            this.payment = trade.getPayment();
            this.username = user.getName();
            this.price = order.getPrice();
        }
    }
}
