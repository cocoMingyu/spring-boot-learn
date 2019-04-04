package com.kn.springbootlearn.service;

import com.kn.springbootlearn.entity.model.Role;

import java.util.List;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/3/22 18:14
 * @ Modified By:
 */

public interface RoleService {
    List<Role> findAllRole();

    Role getRoleById(Integer id);
}
