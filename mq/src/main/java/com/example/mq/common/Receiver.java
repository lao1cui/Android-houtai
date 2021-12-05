package com.example.mq.common;

import com.example.mq.dao.Machine;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello,queue1")
public class Receiver {
    @RabbitHandler
    public  String processMessage1(Machine machine){
        System.out.println(Thread.currentThread().getName()+"接收到来自hello.queue1队列的消息："+machine.toString());
        return  machine.toString();
    }


}
