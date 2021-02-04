package com.family.project.reactor.core.flux;

import java.math.BigDecimal;
import java.util.Random;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import lombok.Data;
import lombok.SneakyThrows;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

public class FluxConstructDemo {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    private static String toJson(Object e) {
        return objectMapper.writeValueAsString(e);
    }

    public static void main(String[] args) {
        //testCreateFlux();
        //testCombine();
        //testConcat();
        //testCreateFlux();
        testGenerateFlux();
        //testFromIterable();
        //testFluxArray();
        //testFluxEmpty
        //testFluxRange
    }

    /**
     * 异步多线程的方式发布事件
     */
    public static void testCreateFlux() {
        //generate
        //create or push
        //push
        //通过FluxSink API，以同步或者异步方式创建Flux
        //FluxSink.OverflowStrategy.LATEST
        Thread thread = new Thread();
        Flux flux = Flux.<String>create((emitter) -> {

            while (true) {
                emitter.next(new Random().nextLong() + Thread.currentThread().getName());
            }

        }, FluxSink.OverflowStrategy.LATEST);
        flux.subscribe((s) -> {
            System.out.println(s);
        });
    }

    /**
     * 同步的一对一的发布事件
     */
    public static void testGenerateFlux() {
        Flux<String> flux = Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3 * state);
                    if (state == 10) {
                        sink.complete();
                    }
                    return state + 1;
                });
        flux.subscribe((s) -> System.out.println(s));
    }

    /**
     * 这个方法提供了一种惰性策略，发布者不会一开始发布消息，直到订阅者创建实例
     */
    public static void testDefer() {

    }

    /**
     * 从最新的发布者那里获取事件，如果有新的发布者加入，则改用新的发布者。
     * 当最后一个发布者完成所有发布事件，并且没有发布者加入，则flux完成。
     */
    public static void testSwitchOnNext() {

    }

    /**
     * 间隔一定的时间，发送事件
     */
    public static void testInterval() {

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

    /**
     * 构建一个Flux，混合由多个的发布者发布最新事件.
     */
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

    /**
     * 混合多个流，和combineLatest类似，但它要求是同类型的流合并，combineLatest需要提供合并方式
     */
    public static void testMerge() {

    }

    /**
     * 通过混合者，合并多个流成一个输出流，一一对应合并
     */
    public static void testZip() {

    }

    /**
     * 流水线拼接
     */
    public static void testConcat() {
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
