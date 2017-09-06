package com.rick.common.handler;

import com.rick.common.ResultJson;
import com.rick.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Desc : 全局异常捕获
 * User : RICK
 * Time : 2017/8/29 17:19
  */
@ControllerAdvice
@ResponseBody//如果返回的为json数据或其它对象，添加该注解
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({BusinessException.class,Exception.class})
    public ResultJson defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Object o, Exception ex) {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        String msg;
        if(ex instanceof BusinessException){
            msg = ex.getMessage();
        } else {
            msg = "操作异常!";
        }
        ex.printStackTrace();
        return ResultJson.buildFailInstance(msg);
    }
}
