package com.gzr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * 控制器
 *
 * @author gaozhirong
 * @create 2017-11-11 下午8:23
 **/
@Controller
public class WsController {

    /**
     * 通过messagingTemplate向浏览器发送消息
     */
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void handleChat(Principal principal,String msg){
        if(principal.getName().equals("gzr")){
            /**
             * "/queue/notifications" 为浏览器订阅的地址
             * user是接收消息的用户
             * destination 浏览器的订阅地址
             * payload 消息本身
             */
            messagingTemplate.convertAndSendToUser("wisely","/queue/notifications",principal.getName()+"-send:"+msg);

        }else{
            messagingTemplate.convertAndSendToUser("/gzr","/queue/notifications",principal.getName()+"-send:"+msg);
        }
    }

}
