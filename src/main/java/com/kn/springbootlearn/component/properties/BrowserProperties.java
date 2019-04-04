package com.kn.springbootlearn.component.properties;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/2 19:41
 * @ Modified By:
 */
public class BrowserProperties {
    private String loginPage= "/login.html";

    private LoginType loginType=LoginType.REDIRECT;

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
