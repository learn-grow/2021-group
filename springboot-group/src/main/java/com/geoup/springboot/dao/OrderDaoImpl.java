package com.geoup.springboot.dao;

import com.geoup.springboot.configuration.template.BaseJdbcTemplate;
import com.geoup.springboot.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: lisy
 * @version: OrderDaoImpl , v0.1 2021年01月28日 20:13
 * @remark：OrderDaoImpl
 */
@Component
public class OrderDaoImpl extends BaseJdbcTemplate<Order> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    protected JdbcTemplate jdbcTemplate() {
        super.jdbcTemplate = jdbcTemplate;
        return jdbcTemplate;
    }
    
}
