package com.gzr.controller;


import com.gzr.domain.WiselyMessage;
import com.gzr.domain.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {

    /**
     * 1.浏览器向服务端发送请求时  通过@MessageMapping映射/welcome这个地址  类似@RequestMapping
     * 2.服务器端有消息时，会对订阅了@SendTo中路径的浏览器发送消息
     * 3.见ws.html中定义的路径
     * @param message
     * @return
     * @throws InterruptedException
     */
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return new WiselyResponse("Welcome,"+message.getName()+"!");
    }

}
