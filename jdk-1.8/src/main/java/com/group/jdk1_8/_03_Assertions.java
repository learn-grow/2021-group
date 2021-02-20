package com.group.jdk1_8;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author: lisy
 * @version: _03_Assertions , v0.1 2021年02月03日 15:33
 * @remark：_03_Assertions 断言
 */
public class _03_Assertions {

    Predicate<String> predicate = (s) -> s.length() > 0 ;

    boolean f1 = predicate.test("test"); //true
    boolean f2 = predicate.negate().test("test"); //!true

    Predicate<Boolean> nonNull = Objects::nonNull;
    Predicate<Boolean> isNull = Objects::isNull;

    Predicate<String> isEmpty = String::isEmpty;
    Predicate<String> isNotEmpty = isEmpty.negate();


}
