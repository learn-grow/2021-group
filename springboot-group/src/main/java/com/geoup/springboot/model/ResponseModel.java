package com.geoup.springboot.model;

import com.geoup.springboot.enums.ResultEnum;
import lombok.Data;

/**
 * @author: lisy
 * @version: ResponseModel , v0.1 2021年01月28日 14:51
 * @remark：ResponseModel
 */
@Data
public class ResponseModel<T> {

    /**
     * 返回值
     **/
    private int code;

    /**
     * 信息
     **/
    private String msg = "ok";

    /**
     * 数据
     **/
    private T data;

    public ResponseModel() {
    }

    public ResponseModel(ResultEnum result) {
        this.code = result.getCode();
        this.msg = result.getMsg();
    }

}
