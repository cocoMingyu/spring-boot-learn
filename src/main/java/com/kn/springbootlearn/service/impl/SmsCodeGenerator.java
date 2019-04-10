package com.kn.springbootlearn.service.impl;

import com.kn.springbootlearn.component.properties.SecurityProperties;
import com.kn.springbootlearn.entity.ValidateCode;
import com.kn.springbootlearn.service.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/4 11:46
 * @ Modified By:
 */
@Component(value = "smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code,securityProperties.getCode().getSms().getExpireTime());
    }
}
