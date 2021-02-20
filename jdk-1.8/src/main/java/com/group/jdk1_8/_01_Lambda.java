package com.group.jdk1_8;

import java.util.*;

/**
 * @author: lisy
 * @version: _01_Lanbda , v0.1 2021年02月03日 14:59
 * @remark：_01_Lanbda
 */
public class _01_Lambda {


    public static void main(String[] args) {
        List<String> list = Arrays.asList("d" , "e" , "b" , "a");

        /**
         * 集合类排序
         */
        Collections.sort(list , (String p , String q) -> {
            return q.compareTo(p);
        });

        //Lambda 实现排序
        list.sort((p , q) -> p.compareTo(q));

        list.sort(Comparator.reverseOrder());

        list.forEach(p -> System.out.println(p));

    }
}
