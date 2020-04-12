package com.j.openproject.core.strategy.impl;

import org.springframework.stereotype.Component;

import com.j.openproject.core.strategy.WsMessageHandler;
import com.j.openproject.core.strategy.factory.WsMessageHandleFactory;
import com.j.openproject.entity.ReceiveMessage;
import com.j.openproject.enums.MessageTypeEnum;

/**
 * TestMessageHandler
 *
 * @author Joyuce
 * @date 2020年04月08日
 */
@Component
public class TestMessageHandler implements WsMessageHandler {
    /**
     * 处理用户消息
     *
     * @param userId
     * @param msg
     */
    @Override
    public void handlingMessage(Integer userId, ReceiveMessage msg) {

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //消息类型，和客户端定义好
        String messageType = MessageTypeEnum.TEST.getMessageType();
        WsMessageHandleFactory.register(messageType, this.getClass());
    }
}
