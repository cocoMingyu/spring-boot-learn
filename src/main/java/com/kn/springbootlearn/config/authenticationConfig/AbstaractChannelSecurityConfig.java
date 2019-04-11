package com.kn.springbootlearn.config.authenticationConfig;

import com.kn.springbootlearn.authentication.MyAuthenticationFailureHandler;
import com.kn.springbootlearn.authentication.MyAuthenticationSuccessHandler;
import com.kn.springbootlearn.component.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/11 17:49
 * @ Modified By:
 */
public class AbstaractChannelSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        http.formLogin()
            .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
            .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
            .successHandler(myAuthenticationSuccessHandler)
            .failureHandler(myAuthenticationFailureHandler);
    }
}
