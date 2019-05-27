package com.kn.springbootlearn.config.authenticationConfig;

import com.kn.springbootlearn.component.properties.SecurityConstants;
import com.kn.springbootlearn.component.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @ Author:kn
 * @ Description: usernamepasswordAuthenticationFilter (authentication未认证)-->authenticationManager -->AuthenticationProvider -->UserDatailsService -->userDetails
 *                -->authentication(已认证) -->securityContext -->SecurityContextHolder -->SecurityContextPerrsistenceFilter
 * @ Date:Created in 2019/3/29 16:06
 * @ Modified By:
 */
@EnableWebSecurity
public class SecurityConfig extends AbstaractChannelSecurityConfig {
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private SmsCodeAuthenticationScurityConfig smsCodeAuthenticationScurityConfig;
    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;
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
        //密码登录配置
        applyPasswordAuthenticationConfig(http);
        //校验码配置
        http.apply(validateCodeSecurityConfig)
                .and()
                .apply(smsCodeAuthenticationScurityConfig)//短信验证码配置
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(userDetailsService)
                .and()
                .authorizeRequests()
                //匹配放行
                .antMatchers(
                        SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        securityProperties.getBrowser().getLoginPage(),
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //在Security的默认拦截器里，默认会开启CSRF处理，判断请求是否携带了token，如果没有就拒绝访问
                .csrf().disable();

    }
}
