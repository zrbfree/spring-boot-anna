package com.rick.common.exception;

/**
 * Desc : 自定义异常类
 * User : RICK
 * Time : 2017/8/29 17:12
  */
public class BusinessException extends RuntimeException {

    public BusinessException(){

    }

    public BusinessException(String message){
        super(message);
    }

    /**
     * Desc :  获取错误信息
     * User : RICK
     * Time : 2017/8/29 17:16
      */
    public static String getMessage(Exception e,String message){
        String tempMessage = "错误异常信息";

        if (e instanceof BusinessException){
            tempMessage = e.getMessage();
        } else{
            tempMessage = e.getMessage();
        }
        return tempMessage;
    }
}
