package com.kn.springbootlearn.service.impl;

import com.kn.springbootlearn.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/3 10:37
 * @ Modified By:
 */

public class CglibProxy implements MethodInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(CglibProxy.class);

    private Object target;

    public Object bind(Object target){
        this.target=target;
        Enhancer enhancer=new Enhancer();
        //设置父类
        enhancer.setSuperclass(this.target.getClass());
        //回调函数
        enhancer.setCallback(this);
        //创建子类(代理对象)
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = methodProxy.invokeSuper(o, objects);
        logger.info("scheduler 动态代理 打个日志");
        return result;
    }
}
