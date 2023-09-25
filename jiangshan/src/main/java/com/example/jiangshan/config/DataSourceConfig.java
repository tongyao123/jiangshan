/**
 *
 */
package com.example.jiangshan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@EnableTransactionManagement
@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;


    @ConfigurationProperties(prefix = "spring.http.datasource")
    @Bean
    public DataSource dataSource() {

        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create().url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        dataSourceBuilder.driverClassName(driverClassName);
        return  dataSourceBuilder.build();
    }

    public void printProperties() {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("URL: " + url);
    }
}
