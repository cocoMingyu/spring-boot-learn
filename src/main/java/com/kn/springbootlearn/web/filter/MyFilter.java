package com.kn.springbootlearn.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/3/17 17:53
 * @ Modified By:
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("myfilter  process---");
        long starttime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("filter 处理时间="+(System.currentTimeMillis()-starttime));
    }

    @Override
    public void destroy() {
    }
}
