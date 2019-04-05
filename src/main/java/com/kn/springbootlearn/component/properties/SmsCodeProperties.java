package com.kn.springbootlearn.component.properties;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/3 12:20
 * @ Modified By:
 */
public class SmsCodeProperties {
    private int length=6;
    private int expireTime=60;
    private String url="/user,/test";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(int expireTime) {
        this.expireTime = expireTime;
    }
}
