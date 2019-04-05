package com.kn.springbootlearn.service;

import com.kn.springbootlearn.entity.model.Users;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/4 10:40
 * @ Modified By:
 */
public interface UserService {
    Users getUserByName(String name);
}
