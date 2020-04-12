package com.j.openproject.core.strategy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.j.openproject.entity.ReceiveMessage;
import com.j.openproject.enums.MessageTypeEnum;
import com.j.openproject.core.strategy.factory.WsMessageHandleFactory;
import com.j.openproject.core.strategy.WsMessageHandler;
import com.j.openproject.core.WebsocketCore;

/**
 * @author joyuce
 * @Type HeartbeatMessageHandler
 * @Desc
 * @date 2019年10月30日
 * @Version V1.0
 */
@Component
public class HeartbeatMessageHandler implements WsMessageHandler {

    @Autowired
    private WebsocketCore websocketCore;

    /**
     * 处理用户消息
     *
     * @param userId
     * @param msg
     */
    @Override
    public void handlingMessage(Integer userId, ReceiveMessage msg) {
        websocketCore.sendHeartbeatByUserId(userId);
    }

    /**
     * 注册到工厂类
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        //消息类型，和客户端定义好
        String messageType = MessageTypeEnum.HEARTBEAT.getMessageType();
        WsMessageHandleFactory.register(messageType, this.getClass());
    }
}
