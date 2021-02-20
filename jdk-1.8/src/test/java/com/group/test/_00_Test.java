package com.group.test;

import com.group.jdk1_8._00_InterfaceDefault;

/**
 * @author: lisy
 * @version: _00_Test , v0.1 2021年02月03日 14:54
 * @remark：_00_Test
 */
public class _00_Test {

    public static void main(String[] args) {
//        _00_InterfaceDefault interfaceDefault = new _00_InterfaceDefault() {
//            @Override
//            public void sendMsg(String info) {
//                return;
//            }
//        };
//
//        interfaceDefault.send("send");

        _00_InterfaceDefault interfaceDefault1 = p -> {

        };
        interfaceDefault1.send("");

    }
}
