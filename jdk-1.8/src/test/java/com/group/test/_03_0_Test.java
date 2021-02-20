package com.group.test;

import com.group.jdk1_8._00_InterfaceDefault;
import com.group.jdk1_8._02_Functional;

/**
 * @author: lisy
 * @version: _00_Test , v0.1 2021年02月03日 14:54
 * @remark：_00_Test
 */
public class _03_0_Test {

    public static void main(String[] args) {

        _02_Functional<String ,String> functional = new _02_Functional<String, String>() {
            @Override
            public String send(String from) {
                return from + "_";
            }
        };

        System.out.println(functional.send("form"));


        _02_Functional<String ,String> functional1 = (from) -> {
            return from + "_";
        };
        System.out.println(functional1.send("form"));

        _02_Functional<String ,String> functional2 = from -> from + "_";
        System.out.println(functional2.send("form"));

    }
}
