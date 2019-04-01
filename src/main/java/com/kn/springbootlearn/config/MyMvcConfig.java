package com.kn.springbootlearn.config;

import com.kn.springbootlearn.component.MyHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/3/16 14:01
 * @ Modified By:
 */

/**
 * WebMvcConfigurerAdapter可以扩展springMvc功能
 * Configuration 注明是配置文件,让spring扫描到
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter{
    @Autowired
    private MyHandle myHandle;

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean
    public WebMvcConfigurerAdapter webMvcAutoConfigurationAdapter(){
        WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter(){
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                super.addInterceptors(registry);
            }
        };
        return webMvcConfigurerAdapter;
    }

    //添加自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //super.addInterceptors(registry);
        registry.addInterceptor(myHandle);
    }
}
