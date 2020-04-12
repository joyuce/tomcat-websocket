package com.j.openproject.core.strategy.factory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.j.openproject.core.strategy.WsMessageHandler;
import com.j.openproject.utils.SpringContextUtil;

/**
 * @author joyuce
 * @Type WSMessageHandleFactory
 * @Desc websocket消息处理工厂类
 * @date 2019年10月30日
 * @Version V1.0
 */
@Component
public class WsMessageHandleFactory {

    private static final Map<String, Class> handleMap = new HashMap<>();

    public static void register(String messageType, Class clazz) {
        handleMap.put(messageType, clazz);
    }

    @SuppressWarnings("unchecked")
    public WsMessageHandler getHandlerByType(String messageType) {
        Class<WsMessageHandler> clazz = handleMap.get(messageType);
        WsMessageHandler messageHandler = SpringContextUtil.getBean(clazz);
        return messageHandler;
    }

}

