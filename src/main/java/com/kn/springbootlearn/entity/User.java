package com.kn.springbootlearn.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ Author:kn
 * @ Description:
 * @ Date:Created in 2019/3/16 13:34
 * @ Modified By:
 */

/**
 * @ Component 标注是容器的组件
 * @ ConfigurationProperties  将配置文件的每一个属性映射到这个组件
 */
/*@Component
@ConfigurationProperties(prefix = "user")*/
public class User {
    private String name;
    private Integer age;
    private Map<String,Object> map;
    private List list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + ", map=" + map + ", list=" + list + '}';
    }
}
