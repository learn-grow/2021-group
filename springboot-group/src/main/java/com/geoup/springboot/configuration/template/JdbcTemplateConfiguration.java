package com.geoup.springboot.configuration.template;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author: lisy
 * @version: JdbcTemplateConfiguration , v0.1 2021年01月28日 20:26
 * @remark：JdbcTemplateConfiguration
 */
@Configuration
public class JdbcTemplateConfiguration {

    @Bean(name = "orderDataSource")
    @ConfigurationProperties(prefix = "spring.jdbc.datasource.order")
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "orderJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("orderDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
