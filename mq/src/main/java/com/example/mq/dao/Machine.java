package com.example.mq.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.mq.dto.Status;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "MACHINE")
public class Machine implements Serializable {
    private String id;
    private String type;
    private Status status;
    private String location;
    private String locationleft;
    private Date time;
}
