package com.family.spring.jpa;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.family.spring.jpa.entity.SingleTable;
import com.family.spring.jpa.repository.SingleTableRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableJpaRepositories
@SpringBootApplication
public class JpaDemoApplication implements ApplicationRunner {

    @Autowired
    private SingleTableRepository singleTableRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 10000; i++) {
            SingleTable singleTable = new SingleTable();
            singleTable.setKey1(RandomStringUtils.random(25, true, true));
            singleTable.setKey2(20000 + i);
            singleTable.setKey3(RandomStringUtils.random(5, true, true));
            singleTable.setKeyPart1(RandomStringUtils.random(10, true, true));
            singleTable.setKeyPart2(RandomStringUtils.random(15, true, true));
            singleTable.setKeyPart3(RandomStringUtils.random(20, true, true));
            singleTableRepository.save(singleTable);
        }

    }
}
