package com.example.mq.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "Doc")
public class Doc {
    private String id;
    private String name;
    private String jianjie;
}
