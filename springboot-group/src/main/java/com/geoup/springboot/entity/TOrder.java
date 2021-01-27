package com.geoup.springboot.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: lisy
 * @version: TOrders , v0.1 2021年01月26日 17:33
 * @remark：TOrders
 */
@Data
public class TOrder {

    /** 主键id **/
    private Integer id;

    /** 订单号 **/
    private String orderNo;

    /** 用户id **/
    private String userId;

    /** 订单描述 **/
    private String commodityCode;

    /** count **/
    private Integer count;

    /** 金额 **/
    private Double amount;

}
