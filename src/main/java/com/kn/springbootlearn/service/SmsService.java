package com.kn.springbootlearn.service;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/4 11:29
 * @ Modified By:
 */
public interface SmsService {

    void send(String mobile,String code);
}
