package com.group.jdk1_8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author: lisy
 * @version: _03_Assertions , v0.1 2021年02月03日 15:33
 * @remark：_03_Assertions 断言
 */
public class _03_Functions {

    public static void main(String[] args) {
        Function<String , Integer> toInteger = Integer::valueOf; //string 转 int

        Function<String ,String> toString = toInteger.andThen(String::valueOf);

        Supplier<Pay> pay = Pay::new;
        pay.get();

        Consumer<Pay> payConsumer = new Consumer<Pay>() {
            @Override
            public void accept(Pay pay) {
                System.out.println("the " + pay.toString());
            }
        };

        Consumer<Pay> payConsumer1 = (p) -> System.out.println("the2 " + p.toString());

        payConsumer1.accept(new Pay("0001" , "order02"));

    }

}
