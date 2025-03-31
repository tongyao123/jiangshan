package com.example.jiangshan.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = SupplyDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "supplySqlSessionFactory")
public class SupplyDataSourceConfig {

    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.example.jiangshan.mapper.supply";
    static final String MAPPER_LOCATION = "classpath:mapper/supply/*.xml";

    @Value("${supply.dateSource.url}")
    private String url;

    @Value("${supply.dateSource.username}")
    private String user;

    @Value("${supply.dateSource.password}")
    private String password;

    @Value("${supply.dateSource.driver-class-name}")
    private String driverClass;

    @Bean(name = "supplyDataSource")
    public DataSource clusterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "supplyTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(clusterDataSource());
    }

    @Bean(name = "supplySqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("supplyDataSource") DataSource clusterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(SupplyDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}