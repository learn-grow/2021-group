package com.geoup.springboot.configuration.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author: lisy
 * @version: DbPayDataSourceConfig , v0.1 2021年01月26日 17:12
 * @remark：DbPayDataSourceConfig
 */
@Slf4j
@Configuration
@MapperScan(basePackages = "com.geoup.springboot.dao" , sqlSessionFactoryRef = "payDataSqlSessionFactory")
public class DbPayDataSourceConfig {

    private static final String MAPPER_URL = "classpath*:mapper/*.xml";

    @Bean(name = "payDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.pay")
    public DataSource dataSource() {
        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
        return druidDataSource;
    }

    @Bean(name = "payDataSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("payDataSource") DataSource ds) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(ds);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_URL));
        return bean.getObject();
    }

    @Bean(name = "payDataSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("payDataSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 事务管理
     * @param ds
     * @return
     */
    @Bean(name = "payDataSourceTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("payDataSource") DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }

}
