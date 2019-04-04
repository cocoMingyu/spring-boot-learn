package com.kn.springbootlearn.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/3 11:24
 * @ Modified By:
 */
public class ValidateException extends AuthenticationException {
    public ValidateException(String msg) {
        super(msg);
    }
}
