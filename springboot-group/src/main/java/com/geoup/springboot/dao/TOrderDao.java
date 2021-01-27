package com.geoup.springboot.dao;

import com.geoup.springboot.entity.TOrder;
import org.apache.ibatis.annotations.Param;

/**
 * @author: lisy
 * @version: TOrdersDao , v0.1 2021年01月26日 17:29
 * @remark：TOrdersDao
 */
public interface TOrderDao {


    /**根据id 查询订单 **/
    TOrder getOrder(Integer id);

    /** 创建 订单，不存则新增，否则修改金额 **/
    void addOrder(@Param(value = "order") TOrder order);

}
