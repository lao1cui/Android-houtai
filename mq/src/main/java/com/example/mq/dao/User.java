package com.example.mq.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class User {
    private String id;
    private String name;
    private String pwd;

}
