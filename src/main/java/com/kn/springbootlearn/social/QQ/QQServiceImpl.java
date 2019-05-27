package com.kn.springbootlearn.social.QQ;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kn.springbootlearn.entity.QQUserInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.io.IOException;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/12 14:41
 * @ Modified By:
 */
public class QQServiceImpl extends AbstractOAuth2ApiBinding implements QQService {
    private static final String URL_GET_OPENID="https://graph.qq.com/oauth2.0/me?access_token=%s";
    private static final String URL_GET_USERINFO="https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";
    private String openId;
    private String appId;
    private ObjectMapper objectMapper=new ObjectMapper();

    public QQServiceImpl(String accessToken,String appId) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;
        String url = String.format(URL_GET_OPENID, accessToken);
        String result = getRestTemplate().getForObject(url, String.class);
        System.out.println(result);
        this.openId=StringUtils.substringBetween(result,"\"openid\":","}");
    }

    @Override
    public QQUserInfo getQQUserInfo() throws IOException {
        String url = String.format(URL_GET_USERINFO, appId, openId);
        String result = getRestTemplate().getForObject(url, String.class);
        QQUserInfo qqUserInfo = objectMapper.readValue(result, QQUserInfo.class);
        return qqUserInfo;
    }
}
