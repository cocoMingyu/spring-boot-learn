package com.kn.springbootlearn.controller;

import com.kn.springbootlearn.entity.Role;
import com.kn.springbootlearn.exception.TestException;
import com.kn.springbootlearn.mapper.RoleMapper;
import com.kn.springbootlearn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/3/17 14:41
 * @ Modified By:
 */
@RestController
public class TestController {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleService roleService;

    @GetMapping("/test")
    public String testException(@RequestParam("name")String name) throws Exception {
        if ("a".equals(name)){
            throw new TestException();
        }
        return "ok";
    }


    @GetMapping("/get/{id}")
    public Role getrole(@PathVariable Integer id){
        return roleService.getRoleById(id);
    }

    @GetMapping("/getall")
    public List<Role> getAll(){
        return roleService.findAllRole();
    }
}
