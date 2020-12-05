package com.jike.family.spring.redis.jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootApplication
@Slf4j
public class JedisDemoApplication implements ApplicationRunner {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private JedisPoolConfig jedisPoolConfig;

    @Bean
    @ConfigurationProperties("redis")
    public JedisPoolConfig jedisPoolConfig() {
        return new JedisPoolConfig();
    }

    @Bean(destroyMethod = "close")
    public JedisPool jedisPool(@Value("${redis.host}") String host) {
        return new JedisPool(jedisPoolConfig(), host);
    }

    public static void main(String[] args) {
        SpringApplication.run(JedisDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info(jedisPoolConfig.toString());
        try (Jedis jedis = jedisPool.getResource()) {
            List<String> list = new ArrayList<>();
            list.add("abc");
            list.add("def");
            list.forEach(c -> jedis.hset("springbucks-menu", c, c));

            Map<String, String> menu = jedis.hgetAll("springbucks-menu");
            log.info("Menu: {}", menu);
        }
    }
}
