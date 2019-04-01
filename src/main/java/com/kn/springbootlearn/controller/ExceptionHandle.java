package com.kn.springbootlearn.controller;

import com.kn.springbootlearn.exception.TestException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/3/17 14:42
 * @ Modified By:
 */
//处理其他controller的异常
@ControllerAdvice
public class ExceptionHandle {
/*
    @ResponseBody
    @ExceptionHandler(TestException.class)
    public Map<String,Object> testHandle(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code",500);
        map.put("message",e.getMessage());
        request.setAttribute("exc",map);
        return map;
    }
*/
    //这个注解是指当controller中抛出这个指定的异常类的时候，都会转到这个方法中来处理异常
    @ExceptionHandler(TestException.class)
    public String testHandle(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code",500);
        map.put("message",e.getMessage());
        request.setAttribute("exc",map);
        //转发到/error进行自适应响应效果处理
        return "forward:error";
    }

}
