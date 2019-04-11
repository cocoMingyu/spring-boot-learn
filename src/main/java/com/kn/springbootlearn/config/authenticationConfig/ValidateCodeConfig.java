package com.kn.springbootlearn.config.authenticationConfig;

import com.kn.springbootlearn.component.properties.SecurityProperties;
import com.kn.springbootlearn.service.SmsService;
import com.kn.springbootlearn.service.ValidateCodeGenerator;
import com.kn.springbootlearn.service.impl.ImageCodeGenerator;
import com.kn.springbootlearn.service.impl.SmsServiceImpl;
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
}
