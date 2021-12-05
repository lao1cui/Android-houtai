package com.example.mq.Service;

import com.example.mq.dao.User;
import com.example.mq.mapper.UseraMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.Objects;
@Service
public class UserService {
    @Autowired
    UseraMapper useraMapper;
    public boolean admin(String name,String pwd){
        User user=useraMapper.selectUser(name,pwd);
        if (Objects.nonNull(user)){
            return true;
        }else{
            return false;
        }
    }
}
