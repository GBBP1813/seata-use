package com.example.demo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.example.demo")
public class SeataAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountApplication.class, args);
    }

}
