package com.example.mq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mq.dao.Machine;
import com.example.mq.dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UseraMapper extends BaseMapper<User> {
    @Select("select * from user u where u.name=#{name} and u.pwd=#{pwd}")
    User selectUser(@Param("name") String name,@Param("pwd") String pwd);
}
