package com.kn.springbootlearn.config;

import com.kn.springbootlearn.component.properties.SecurityProperties;
import com.kn.springbootlearn.service.ValidateService;
import com.kn.springbootlearn.service.impl.ValidateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/3 21:35
 * @ Modified By:
 */
@Configuration
public class ValidateCodeConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    @ConditionalOnMissingBean(name = "validateService")
    public ValidateService validateService(){
        ValidateServiceImpl validateService = new ValidateServiceImpl();
        validateService.setSecurityProperties(securityProperties);
        return validateService;
    }
}
