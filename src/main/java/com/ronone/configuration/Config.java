package com.ronone.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.DatabaseMetaData;

@Configuration
public class Config {



    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.ds_buyer")
    public DataSource buyerDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.ds_toner")
    public DataSource tonerDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.ds_manager")
    public DataSource managerDataSource(){
        return DataSourceBuilder.create().build();
    }
}
