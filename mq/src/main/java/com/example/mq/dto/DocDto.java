package com.example.mq.dto;

import com.example.mq.dao.Doc;
import lombok.Data;

import java.util.List;

@Data
public class DocDto {
    private boolean success =true;
    private List<Doc> data;
       }
