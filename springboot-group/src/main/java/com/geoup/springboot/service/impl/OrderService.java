package com.geoup.springboot.service.impl;

import com.geoup.springboot.dao.OrderDao;
import com.geoup.springboot.entity.Order;
import com.geoup.springboot.enums.ResultEnum;
import com.geoup.springboot.model.ResponseModel;
import com.geoup.springboot.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author: lisy
 * @version: OrderServiceImpl , v0.1 2021年01月26日 18:06
 * @remark：OrderServiceImpl
 */
@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderDao orderDao;

    public ResponseModel<Order> getOrder(Integer id) {
        ResponseModel<Order> responseModel = new ResponseModel(ResultEnum.ok);
        Order order = orderDao.getOrder(id);
        if (null != order) {
            responseModel.setData(order);
        }
        return responseModel;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class, value = "payDataSourceTransactionManager")
    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }
}
