package com.example.mq.controller;

import com.example.mq.Service.DocService;
import com.example.mq.dao.Doc;
import com.example.mq.dto.DocDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@ResponseBody
@RequestMapping("/")
public class DocController {
    @Autowired
    DocService docService;
    @GetMapping("hello")
    public String hello(){
        if (Objects.nonNull(docService)) {
            return docService.sayHello();
        }else {
            return "hello mafeqwfnqpjegv";
        }
    }
    @GetMapping("user")
    public DocDto user(){
        if (Objects.nonNull(docService)) {
            DocDto dto = new DocDto();
            dto.setData(docService.allDoc());
            return dto;
        }else {
            return null;
        }
    }
}
