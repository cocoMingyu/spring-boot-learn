package com.kn.springbootlearn.exception;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/3/17 14:23
 * @ Modified By:
 */
public class TestException  extends RuntimeException{
    public TestException() {
        super("测试异常");
    }
}
