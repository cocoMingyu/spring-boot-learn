package com.kn.springbootlearn.config;

import com.kn.springbootlearn.authentication.MyAuthenticationFailureHandler;
import com.kn.springbootlearn.authentication.MyAuthenticationSuccessHandler;
import com.kn.springbootlearn.component.properties.SecurityProperties;
import com.kn.springbootlearn.web.filter.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/3/29 16:06
 * @ Modified By:
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private MyAuthenticationSuccessHandler knAuthenticationHandler;
    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetailsService userDetailsService;

    //使用security的加密规则对密码进行加密,也可以自定义
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository=new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //创建一个保存用户token信息的表,第二次启动注释,重复建表报错
        //jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidateCodeFilter validateCodeFilter=new ValidateCodeFilter();
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.setMyAuthenticationFailureHandler(myAuthenticationFailureHandler);
        validateCodeFilter.afterPropertiesSet();

        //在Security的默认拦截器里，默认会开启CSRF处理，判断请求是否携带了token，如果没有就拒绝访问
        http.csrf().disable();
        //在那个拦截器之前执行
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/authentication/require")//自定义登陆界面
                .loginProcessingUrl("/authentication/form")
                .successHandler(knAuthenticationHandler)
                .failureHandler(myAuthenticationFailureHandler)
                .and()
             .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(userDetailsService)
                .and()
                .authorizeRequests()
                //匹配放行
                .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage(),
                        "/code/image").permitAll()
                .anyRequest()
                .authenticated();
    }

    /*//定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
       *//* auth.inMemoryAuthentication()
                .withUser("kn").password("123456").roles("VIP1","VIP2","VIP3")
                .and()
                .withUser("xx").password("123456").roles("VIP1");*//*
    }*/
}
