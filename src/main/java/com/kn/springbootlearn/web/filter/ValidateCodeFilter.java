package com.kn.springbootlearn.web.filter;

import com.kn.springbootlearn.authentication.MyAuthenticationFailureHandler;
import com.kn.springbootlearn.component.properties.SecurityProperties;
import com.kn.springbootlearn.exception.ValidateException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/3 11:17
 * @ Modified By:
 */
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    private SessionStrategy sessionStrategy= new HttpSessionSessionStrategy();

    private Set<String> urls=new HashSet<>();

    private SecurityProperties securityProperties;

    private PathMatcher pathMatcher=new AntPathMatcher();

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        String[] split = StringUtils.split(securityProperties.getCode().getImage().getUrl(), ",");
        for (String s : split) {
            urls.add(s);
        }
        urls.add("/authentication/form");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        boolean result = false;
        for (String url : urls) {
            if (pathMatcher.match(url, httpServletRequest.getRequestURI())) {
                result = true;
            }
        }

        if (result) {
            try {
                validate(new ServletWebRequest(httpServletRequest));
            } catch (ValidateException e) {
                myAuthenticationFailureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
                return;
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void validate(ServletWebRequest servletWebRequest){

    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    public MyAuthenticationFailureHandler getMyAuthenticationFailureHandler() {
        return myAuthenticationFailureHandler;
    }

    public void setMyAuthenticationFailureHandler(MyAuthenticationFailureHandler myAuthenticationFailureHandler) {
        this.myAuthenticationFailureHandler = myAuthenticationFailureHandler;
    }
}
