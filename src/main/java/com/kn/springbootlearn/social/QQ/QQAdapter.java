package com.kn.springbootlearn.social.QQ;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/12 18:23
 * @ Modified By:
 */
public class QQAdapter implements ApiAdapter<QQService> {
    @Override
    public boolean test(QQService qqService) {
        return false;
    }

    @Override
    public void setConnectionValues(QQService qqService, ConnectionValues connectionValues) {

    }

    @Override
    public UserProfile fetchUserProfile(QQService qqService) {
        return null;
    }

    @Override
    public void updateStatus(QQService qqService, String s) {

    }
}
