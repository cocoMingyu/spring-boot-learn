package com.kn.springbootlearn.web.aspect;

import org.springframework.messaging.handler.HandlerMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/3/17 10:47
 * @ Modified By:
 */
@Component
public class MyHandle implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*System.out.println("this is preHandle");
        request.setAttribute("starttime", new Date().getTime());*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
/*        System.out.println("this is posthandle");
        Long starttime = (Long) request.getAttribute("starttime");
        System.out.println("posthandle 处理时间="+(new Date().getTime()-starttime ));*/
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
/*        System.out.println("this is afterCompletion");
        Long starttime = (Long) request.getAttribute("starttime");
        System.out.println("afterCompletion 处理时间="+(new Date().getTime()-starttime ));*/
    }
}
