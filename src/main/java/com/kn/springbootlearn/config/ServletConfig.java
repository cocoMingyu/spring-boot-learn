package com.kn.springbootlearn.config;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/3/17 17:14
 * @ Modified By:
 */

/*@Configuration
public class ServletConfig {
    //注册三大组件
    @Bean
    public ServletRegistrationBean servlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(), "/servlet");
        return registrationBean;
    }
    @Bean
    public FilterRegistrationBean filter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/a","/b"));
        return filterRegistrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean listener(){
        return new ServletListenerRegistrationBean<>(new MyListener());
    }

    //配置嵌入式的servlet容器
    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
        return new EmbeddedServletContainerCustomizer() {
            //定制嵌入式servlet容器相关规则
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.setPort(8080);
            }
        };
    }
}*/
