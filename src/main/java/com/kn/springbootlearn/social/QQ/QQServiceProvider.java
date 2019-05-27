package com.kn.springbootlearn.social.QQ;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/12 17:07
 * @ Modified By:
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQService> {
    private String appId;
    private static final String URL_AUTHRIZE="https://graph.qq.com/oauth2.0/authorize";
    private static final String URL_ACCESS_TOKEN="https://graph.qq.com/oauth2.0/token";
    @Override
    public QQService getApi(String accessToken) {
        return new QQServiceImpl(accessToken,appId);
    }

    public QQServiceProvider(String appId,String appSecret) {
        super(new OAuth2Template(appId,appSecret,URL_AUTHRIZE,URL_ACCESS_TOKEN));
    }
}
