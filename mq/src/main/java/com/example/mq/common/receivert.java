package com.example.mq.common;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello,queue2")
public class receivert {
    @RabbitHandler
    public void processMessage2(String msg){
        System.out.println(Thread.currentThread().getName()+"接收到来着hello.queue2队列的消息："+msg);
    }
}
