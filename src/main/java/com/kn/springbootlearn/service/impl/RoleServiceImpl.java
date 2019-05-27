package com.kn.springbootlearn.service.impl;

import com.kn.springbootlearn.entity.model.Role;
import com.kn.springbootlearn.mapper.RoleMapper;
import com.kn.springbootlearn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/3/22 18:14
 * @ Modified By:
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private StringRedisTemplate StrinfRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *  cacheNames/value:指定缓存组件名字,是数组形式
     *  key:缓存数据使用的key:可以用它指定.默认方法参数值
     *  keyGenerator:key生成器,指定key生成器的组件id,key/keyGenerator二选一
     *  cacheManager:指定缓存管理器,或者cacheResolver 指定解析器
     *  condition:指定符合条件才缓存
     *  unless:指定条件为true,不缓存
     */
    //@Cacheable(value = "role")
    @Override
    public List<Role> findAllRole(){
        return roleMapper.getAllRole();
    }

    @Override
    public Role getRoleById(Integer id){
        Role role = roleMapper.findRoleById(id);
        StrinfRedisTemplate.opsForValue().set(id.toString(),role.toString());
        return role;
    }

    /*@RabbitListener(queues = "user.name")
    public void roleListener(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }*/

    /**
     * 监听队列
     * @param message
     */
    /*@RabbitListener(queues = "user.name")
    public void roleListener(List message){
        System.out.println(message);
    }*/

}
