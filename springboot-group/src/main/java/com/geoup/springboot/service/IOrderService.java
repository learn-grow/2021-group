package com.geoup.springboot.service;

import com.geoup.springboot.entity.Order;
import com.geoup.springboot.model.ResponseModel;


/**
 * @author: lisy
 * @version: OrderService , v0.1 2021年01月26日 18:06
 * @remark：OrderService
 */
public interface IOrderService {

    /**根据id 查询订单 **/
    ResponseModel<Order> getOrder(Integer id);

    /** 创建 订单，不存则新增，否则修改金额 **/
    void addOrder(Order order);
}
