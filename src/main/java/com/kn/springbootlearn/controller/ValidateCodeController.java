package com.kn.springbootlearn.controller;

import com.kn.springbootlearn.component.properties.SecurityProperties;
import com.kn.springbootlearn.entity.ImageCode;
import com.kn.springbootlearn.entity.ValidateCode;
import com.kn.springbootlearn.service.SmsService;
import com.kn.springbootlearn.service.ValidateCodeGenerator;
import com.kn.springbootlearn.service.ValidateCodeProcessor;
import com.kn.springbootlearn.service.impl.ImageCodeGenerator;
import com.kn.springbootlearn.service.impl.SmsCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/3 11:07
 * @ Modified By:
 */
@RestController
public class ValidateCodeController {
    public static  final String SESSION_KEY="SESSION_KEY_FOR_CODE_";
    private SessionStrategy sessionStrategy=new HttpSessionSessionStrategy();
    @Autowired
    private ImageCodeGenerator imageCodeGenerator;
    @Autowired
    private SmsCodeGenerator smsCodeGenerator;
    @Autowired
    private SmsService smsService;
    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessor;
    @GetMapping("code/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type)
            throws Exception {
        validateCodeProcessor.get(type+"ValidateCodeProcessor").create(new ServletWebRequest(request, response));
    }


    /*@GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode = imageCodeGenerator.generate(new ServletWebRequest(request));
        sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,imageCode);
        ImageIO.write(imageCode.getImage(),"JPEG",response.getOutputStream());
    }

    @GetMapping("/code/sms")
    public void createSmsCode(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException {
        ValidateCode smsCode = smsCodeGenerator.generate(new ServletWebRequest(request));
        sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,smsCode);
        String mobile = ServletRequestUtils.getRequiredStringParameter(request, "mobile");
        smsService.send(mobile,smsCode.getCode());
    }*/
}
