package com.group.jdk1_8;

/**
 * @author: lisy
 * @version: _00_Test , v0.1 2021年02月03日 14:49
 * @remark：_00_Test 接口可提供默认的方法
 */
public interface _00_InterfaceDefault {

    default void send(String info) {
        System.out.println("default ");
    }

    void sendMsg(String info);


}
