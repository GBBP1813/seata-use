package com.example.seata.transcation.manage;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.example.seata.transcation.manage")
public class SeataTranscationManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataTranscationManageApplication.class, args);
    }

}
