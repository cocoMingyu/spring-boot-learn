package com.kn.springbootlearn.service;

import com.kn.springbootlearn.entity.ValidateCode;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/3 21:25
 * @ Modified By:
 */
public interface ValidateCodeGenerator {
    ValidateCode generate(ServletWebRequest request);
}
