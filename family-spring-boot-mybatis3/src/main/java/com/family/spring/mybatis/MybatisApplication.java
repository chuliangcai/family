package com.family.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisApplication implements ApplicationRunner {

    @Autowired
    private StudentMapper studentMapper;

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Student> studentList = studentMapper.findAll();
        System.out.println(studentList);
    }
}
