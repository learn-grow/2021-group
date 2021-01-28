package com.geoup.springboot.enums;

/**
 * @author: lisy
 * @version: CodeEnums , v0.1 2021年01月28日 14:56
 * @remark：CodeEnums 返回值编码
 */
public enum ResultEnum {

    /** 成功 **/
    ok(2000 , "ok"),

    /**参数异常**/
    param_error(4000 , "param_error"),

    /**服务异常**/
    fail(5000 , "server_error"),;


    private int code;

    private String msg;

    ResultEnum(int code , String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
