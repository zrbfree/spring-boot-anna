package com.rick.utils;

import java.util.UUID;

/**
 * Desc :  字符串工具类
 * User : RICK
 * Time : 2017/8/30 9:34
  */
public class StringUtil {

    /**
     * Desc :  生成随机32位字符串
     * User : RICK
     * Time : 2017/8/30 9:35
      */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * Desc :  判断段是否为空
     * User : RICK
     * Time : 2017/8/30 15:57
      */
    public static boolean isNull(Object o){
        if (o == null || "".equals(0) || "null".equals(o)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Desc : 判断是否不为空
     * User : RICK
     * Time : 2017/8/30 15:58
      */
    public static boolean isNotNull(Object o){
        return !isNull(o);
    }



}
