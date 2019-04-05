package com.kn.springbootlearn.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kn.springbootlearn.component.properties.LoginType;
import com.kn.springbootlearn.component.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/2 22:36
 * @ Modified By:
 */
@Component("myAuthenticationFailureHandler")
public class MyAuthenticationFailureHandler extends ExceptionMappingAuthenticationFailureHandler {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        if (securityProperties.getBrowser().getLoginType().equals(LoginType.JSON)){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(e.getMessage()));
        }else {
            super.onAuthenticationFailure(request, response, e);
        }

    }
}
