package com.example.seata.order.config;

import com.example.utils.DataSourceMyUtils;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.context.support.UiApplicationContextUtils;
import sun.misc.ObjectInputFilter;

import javax.sql.DataSource;

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
        String applicationName = ConfigUtils.properties.getProperty("spring.application.name");
        String txServiceGroup = ConfigUtils.properties.getProperty("tx.service.group");
        return  new GlobalTransactionScanner(applicationName, txServiceGroup);
    }
}
