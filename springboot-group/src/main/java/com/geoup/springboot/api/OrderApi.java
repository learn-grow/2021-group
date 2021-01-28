package com.geoup.springboot.api;


import com.geoup.springboot.entity.Order;
import com.geoup.springboot.model.ResponseModel;
import com.geoup.springboot.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lisy
 * @version: OrderApi , v0.1 2021年01月28日 14:50
 * @remark：OrderApi
 */
@RestController(value = "/api")
public class OrderApi {

    @Autowired
    IOrderService orderService;

    @RequestMapping("order/getorder")
    public ResponseModel<Order> getOrder(Integer id) {
        ResponseModel<Order> order = orderService.getOrder(id);
        return order;
    }
}
