package com.kn.springbootlearn.service.impl;

import com.kn.springbootlearn.entity.model.Users;
import com.kn.springbootlearn.mapper.UserMapper;
import com.kn.springbootlearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/4 10:40
 * @ Modified By:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Users getUserByName(String name){
        return userMapper.findUserByName(name);
    }
}
