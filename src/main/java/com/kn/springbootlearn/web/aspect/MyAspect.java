package com.kn.springbootlearn.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/3/31 16:31
 * @ Modified By:
 */
@Component
@Aspect
public class MyAspect {
    //第一个* 任何参数，第二个* 任何方法
    @Around("execution(* com.kn.springbootlearn.controller.TestController.*(..))")
    public Object controllerAspect(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("this is aspect");
        long time = new Date().getTime();
        //携带的请求参数
        for (Object o : pjp.getArgs()) {
            System.out.println("arg is "+o);
        }
        Object proceed = pjp.proceed();
        System.out.println("执行 aspect 耗时："+(new Date().getTime()-time));
        return proceed;
    }
}
