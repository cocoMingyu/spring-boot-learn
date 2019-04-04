package com.kn.springbootlearn.component.properties;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/3 12:20
 * @ Modified By:
 */
public class ImageCodeProperties {
    private int width=67;
    private int height=23;
    private int length=4;
    private int expireTime=60;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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
