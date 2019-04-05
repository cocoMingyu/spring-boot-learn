package com.kn.springbootlearn.entity;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/4 11:15
 * @ Modified By:
 */
public class ValidateCode {
    private String code;
    private LocalDateTime expireTime;

    public ValidateCode() {
    }

    public ValidateCode(String code, int expireTime) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireTime);
    }

    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    public boolean isExpired(){
        return LocalDateTime.now().isAfter(expireTime);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
