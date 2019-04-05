package com.kn.springbootlearn.service.impl;

import com.kn.springbootlearn.service.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/4 11:29
 * @ Modified By:
 */
public class SmsServiceImpl implements SmsService {
    private static final Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

    @Override
    public void send(String mobile,String code){
        logger.info("发送短信,mobile={},code={}",mobile,code);
    }
}
