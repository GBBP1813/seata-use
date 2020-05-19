package com.example.seata.storage.config;

import com.example.utils.DataSourceMyUtils;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author boomboompow
 * @date 2020/5/19 2:00 PM
 */
@Configuration
public class SeataConfig {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean
    public DataSource getDataSource(){
        return new DataSourceProxy(DataSourceMyUtils.getDatasource(dataSourceProperties));
    }

    @Bean
    public static GlobalTransactionScanner globalTransactionScanner() {
        return  new GlobalTransactionScanner("seata-storage", "my_test_tx_group");
    }
}
