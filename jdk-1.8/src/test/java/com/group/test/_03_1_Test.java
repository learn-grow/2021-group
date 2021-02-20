package com.group.test;

import com.group.jdk1_8.Pay;
import com.group.jdk1_8._02_Functional;
import com.group.jdk1_8._02_Functional_PayService;

/**
 * @author: lisy
 * @version: _00_Test , v0.1 2021年02月03日 14:54
 * @remark：_00_Test
 */
public class _03_1_Test {

    public static void main(String[] args) {
        _02_Functional_PayService<Pay> payService = Pay::new;
        Pay pay = payService.create("0000" , "order_001");
        System.out.println(pay.toString());
    }
}
