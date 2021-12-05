package com.example.mq.controller;

import com.example.mq.Service.UserService;
import com.example.mq.dao.User;
import com.example.mq.dto.DocDto;
import com.example.mq.dto.UserDto;
import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@ResponseBody
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("admin")
    public boolean user(UserDto user){
        if (Objects.nonNull(userService)&&Objects.nonNull(user)) {
             return  userService.admin(user.getName(),user.getPwd());
        }
            return false;
    }
}
