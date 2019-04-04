package com.kn.springbootlearn.component.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/2 19:40
 * @ Modified By:
 */
@ConfigurationProperties(prefix = "kn.security")
public class SecurityProperties {
    private BrowserProperties browser=new BrowserProperties();
    private ValidateCodeProperties code=new ValidateCodeProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }
}
