package com.gzr.socket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
/**
 * @EnableWebSocketMessageBroker注解开启使用STOMP协议来传输基于代理（message broker）的消息
 * 这时使用@MessageMapping就好像使用@RequestMapping一样
 */
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
    /**
     * 注册STOMP协议的节点 指定映射的url  指定使用socketJs协议
     * @param stompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/endpointWisely").withSockJS();//3
    }

    /**
     * 广播式 会将消息发送给所有连接了当前endpoint的浏览器
     * 配置消息代理
     * 广播式配置/topic消息代理
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");//5
    }
}
