package com.kn.springbootlearn.controller;

import com.kn.springbootlearn.component.properties.SecurityProperties;
import com.kn.springbootlearn.entity.SimpleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/2 10:45
 * @ Modified By:
 */
@RestController
public class BrowserSecurityController {
    private static final Logger logger = LoggerFactory.getLogger(BrowserSecurityController.class);
    //当前请求缓存到session
    private RequestCache requestCache=new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;
    /**
     * @ Author:kn
     * @ Description:需要身份认证,跳转到这里
     * @ Date: 2019/4/2
     */
    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest=requestCache.getRequest(request,response);
        if (savedRequest!=null){
            String url = savedRequest.getRedirectUrl();
            logger.info("引发跳转的请求:"+url);
            if (StringUtils.endsWithIgnoreCase(url,".html")){
                redirectStrategy.sendRedirect(request,response, securityProperties.getBrowser().getLoginPage());
                requestCache.removeRequest(request,response);
            }
        }
        return new SimpleResponse("访问服务需要身份认证,引导用户到登录页");
    }
}
