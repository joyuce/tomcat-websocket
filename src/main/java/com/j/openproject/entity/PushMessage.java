package com.j.openproject.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * @author joyuce
 * @Type PushMessage
 * @Desc 服务端消息推送类
 * @date 2019年05月29日
 * @Version V1.0
 */
@Data
public class PushMessage implements Serializable {

    private static final long serialVersionUID = 1787189811207698820L;

    private String messageType;//消息类型

    private Object messageData;//消息数据

    private int expireTime;//消息过期时间

    private boolean isCollect;//是否消息未接收收集 默认不收集

    private int messageLevel;//消息等级  0 高优先级  1 低优先级

    public PushMessage() {
    }

    public PushMessage(String messageType, Object messageData, int expireTime) {
        this.messageType = messageType;
        this.messageData = messageData;
        this.expireTime = expireTime;
    }

    public PushMessage(String messageType, Object messageData) {
        this.messageType = messageType;
        this.messageData = messageData;
    }

}
