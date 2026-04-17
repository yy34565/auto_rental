package com.tjgd;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tjgd.rental.mapper")
public class AppService {
    public static void main(String[] args) {
        SpringApplication.run(AppService.class, args);

    }
}
