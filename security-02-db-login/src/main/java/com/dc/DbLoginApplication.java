package com.dc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.dc.mapper"})
public class DbLoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(DbLoginApplication.class, args);
    }
}
