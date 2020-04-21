package com.example.seata.transcation.manage.config;


import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SeataConfig {


    @Bean
    public static GlobalTransactionScanner globalTransactionScanner() {
        return  new GlobalTransactionScanner("seata-tm", "my_test_tx_group");
    }
}
