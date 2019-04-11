package com.kn.springbootlearn.config.authenticationConfig;

import com.kn.springbootlearn.component.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/2 19:45
 * @ Modified By:
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityPropertiesConfig {
}
