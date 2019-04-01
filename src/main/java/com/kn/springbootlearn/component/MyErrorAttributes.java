package com.kn.springbootlearn.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @ Author:kn
 * @ Description: 出现错误以后，会来到/error请求，会被BasicErrorController处理，响应出去可以获取的数据是由
 *                getErrorAttributes得到的（是AbstractErrorController（ErrorController）规定的方法）；
 *              1、完全来编写一个ErrorController的实现类【或者是编写AbstractErrorController的子类】，放在容器中；
 *              2、页面上能用的数据，或者是json返回能用的数据都是通过errorAttributes.getErrorAttributes得到；
 *              容器中DefaultErrorAttributes.getErrorAttributes()；默认进行数据处理的；
 *              自定义ErrorAttributes
 * @ Date:Created in 2019/3/17 15:28
 * @ Modified By:
 */
//向容器中添加自定义的errorattributes
/*
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("customer","kn");
        //异常处理器携带的数据
        Map exc = (Map) webRequest.getAttribute("exc", 0);
        errorAttributes.put("ext",exc);
        return errorAttributes;
    }


}
*/
