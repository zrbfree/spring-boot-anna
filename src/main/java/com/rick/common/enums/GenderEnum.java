package com.rick.common.enums;

/**
 * Desc :  性别枚举类
 * User : RICK
 * Time : 2017/8/29 16:42
  */
public enum GenderEnum {

    MALE(1, "男"),
    FEMALE(2, "女");


    private GenderEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

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
