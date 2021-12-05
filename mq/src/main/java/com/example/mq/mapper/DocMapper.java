package com.example.mq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mq.dao.Doc;
import com.example.mq.dao.Machine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DocMapper extends BaseMapper<Doc> {
    @Select("select * from Doc")
    List<Doc> selectList();
}
