package com.example.seata.storage;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.example.seata.storage")
public class SeataStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageApplication.class, args);
    }

}
