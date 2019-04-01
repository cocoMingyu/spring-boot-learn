package com.kn.springbootlearn.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/3/29 16:06
 * @ Modified By:
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启自动配置的登录功能，没有登录，权限来到登录页面
        http.formLogin().usernameParameter("user").passwordParameter("pwd").loginPage("/userlogin");
        //1./login开到登录页，2-重定向

        //开启自动配置的注销
        http.logout().logoutSuccessUrl("/");//注销成功后来到首页,清空session

        //开启记住我功能,登陆成功cookie发给浏览器保存，以后访问携带cookie
        http.rememberMe();
    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("kn").password("123456").roles("VIP1","VIP2","VIP3")
                .and()
                .withUser("xx").password("123456").roles("VIP1");
    }
}
