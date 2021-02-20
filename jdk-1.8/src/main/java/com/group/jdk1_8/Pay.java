package com.group.jdk1_8;

/**
 * @author: lisy
 * @version: Pay , v0.1 2021年02月03日 15:15
 * @remark：Pay
 */
public class Pay {

    private String payId;

    private String orderNo;

    public Pay(){}

    public Pay(String payId , String orderNo) {
        this.payId = payId;
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "Pay{" +
                "payId='" + payId + '\'' +
                ", orderNo='" + orderNo + '\'' +
                '}';
    }
}
