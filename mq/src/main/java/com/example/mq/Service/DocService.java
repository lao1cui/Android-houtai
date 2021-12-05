package com.example.mq.Service;

import com.example.mq.dao.Doc;
import com.example.mq.mapper.DocMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocService {
    @Autowired
    DocMapper docMapper;

    public String sayHello(){
        return "hello springboot and dubbo！";
    };

    public List<Doc> allDoc(){
      return   docMapper.selectList();
    }

}
