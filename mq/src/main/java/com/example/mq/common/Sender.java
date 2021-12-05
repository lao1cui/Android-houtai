package com.example.mq.common;

import com.example.mq.dao.Machine;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.interfaces.PBEKey;
import java.util.UUID;

@Component
public class Sender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {
   @Autowired
   private RabbitTemplate rabbitTemplate;
   @PostConstruct
   public  void init(){
       rabbitTemplate.setReturnsCallback(this);
       rabbitTemplate.setConfirmCallback(this);
   }
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if (b){
            System.out.println("消息发送成功：" + correlationData);
        }else {
            System.out.println("消息发送失败："+s);
        }
    }

    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
         System.out.println("ReturnedMessage:"+returnedMessage);
    }

    public void send(String msg,int i){
       CorrelationData correlationData =new CorrelationData(UUID.randomUUID().toString());
        CorrelationData correlationData2 =new CorrelationData(UUID.randomUUID().toString());
        Machine machine=new Machine();
        System.out.println("开始发送消息：" + msg.toLowerCase());
       //三种发送方式
       // 直接发送，参数类型为message
       // rabbitTemplate.send();
       // 转换类型再发送，把object转换为message后发送
       // rabbitTemplate.convertAndSend();
       // 转换类型再发送，把object转换为message后发送，且等待响应
       // rabbitTemplate.convertSendAndReceive();
       rabbitTemplate.convertSendAndReceive("topicExchangeFor","key.1",msg+"这是第"+i+"条消息",correlationData);
       rabbitTemplate.convertSendAndReceive("topicExchangeFor","key.2",msg+"这是第"+i+"条消息",correlationData2);
        System.out.println("结束发送消息："+msg.toLowerCase());
    }


    public void sendMsg(Machine machine){
        CorrelationData correlationData =new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertSendAndReceive("topicExchangeFor","key.1",machine,correlationData);
        System.out.println("结束发送消息："+machine.toString());
    }
}
