package com.jike.family.spring.r2dbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import io.r2dbc.pool.ConnectionPool;

@SpringBootApplication
public class R2dbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(R2dbcDemoApplication.class, args);
    }

    @Bean
    public ConnectionFactoryInitializer initializer(ConnectionPool connectionFactory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource("schema.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("data.sql"));
        initializer.setDatabasePopulator(resourceDatabasePopulator);
        return initializer;
    }
}
