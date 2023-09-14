package com.example.jiangshan.open.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@MapperScan(basePackages = {"com.open.demov2.domain"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfig {

    @Resource(name = "dataSource")
    private DataSource dataSource;

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        factoryBean.getObject().getConfiguration().setCacheEnabled(false);
        factoryBean.getObject().getConfiguration().setLocalCacheScope(LocalCacheScope.STATEMENT);
        log.info("SqlSessionFactory configuration cacheEnabled:{} cacheScope:{}", factoryBean.getObject()
                .getConfiguration().isCacheEnabled(),
                factoryBean.getObject()
                        .getConfiguration().getLocalCacheScope());
        return factoryBean.getObject();
    }

    @Bean("targetSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }
}
