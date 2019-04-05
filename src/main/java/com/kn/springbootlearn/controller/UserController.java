package com.kn.springbootlearn.controller;

import com.kn.springbootlearn.entity.model.Users;
import com.kn.springbootlearn.service.UserService;
import com.kn.springbootlearn.service.impl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/1 16:45
 * @ Modified By:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{name}")
    public Users getUserByName(@PathVariable String name){
        Users user = userService.getUserByName(name);
        return user;
    }
}
