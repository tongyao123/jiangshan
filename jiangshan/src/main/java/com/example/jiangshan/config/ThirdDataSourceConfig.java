//package com.example.jiangshan.config;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.apache.ibatis.session.LocalCacheScope;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//
//@Slf4j
//@Configuration
//@MapperScan(basePackages = {"com.example.jiangshan.domain"}, sqlSessionFactoryRef = "thirdDataSourceConfig")
//public class ThirdDataSourceConfig {
//
//    // 精确到 cluster 目录，以便跟其他数据源隔离
//    static final String PACKAGE = "com.example.jiangshan.mapper.domain";
//    static final String MAPPER_LOCATION = "classpath:mapper/domain/*.xml";
//
//    @Value("${third.dateSource.url}")
//    private String url;
//
//    @Value("${third.dateSource.username}")
//    private String user;
//
//    @Value("${third.dateSource.password}")
//    private String password;
//
//    @Value("${third.dateSource.driver-class-name}")
//    private String driverClass;
//
//    @Bean(name = "thirdDataSource")
//    public DataSource clusterDataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driverClass);
//        dataSource.setUrl(url);
//        dataSource.setUsername(user);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
//
//    @Bean(name = "thirdTransactionManager")
//    public DataSourceTransactionManager clusterTransactionManager() {
//        return new DataSourceTransactionManager(clusterDataSource());
//    }
//
//    @Bean(name = "thirdSqlSessionFactory")
//    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("thirdDataSource") DataSource clusterDataSource)
//            throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(clusterDataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources(ThirdDataSourceConfig.MAPPER_LOCATION));
//        return sessionFactory.getObject();
//    }
//}
