package com.kn.springbootlearn.service.impl;

import com.kn.springbootlearn.entity.model.Users;
import com.kn.springbootlearn.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/1 16:46
 * @ Modified By:
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = userMapper.findUserByName(s);
        //注册时就应该加密密码
        String encode = passwordEncoder.encode(user.getPassword());
        System.out.println(encode);
        return new User(s,encode,true,true,true,
                true,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
