package com.kn.springbootlearn.mapper;

import com.kn.springbootlearn.entity.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/4/1 16:55
 * @ Modified By:
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where nickname=#{nickname}")
    Users findUserByName(@Param("nickname")String nickname);

}
