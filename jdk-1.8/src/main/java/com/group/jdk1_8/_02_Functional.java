package com.group.jdk1_8;

/**
 * @author: lisy
 * @version: _02_Functional , v0.1 2021年02月03日 15:05
 * @remark：_02_Functional 函数式接口 ，一定要有接口
 */
@FunctionalInterface
public interface _02_Functional<F , T> {

    T send(F from);
}
