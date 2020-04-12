package com.j.openproject.entity;

import java.io.Serializable;
import java.util.Set;

import lombok.Data;

/**
 * @author joyuce
 * @Type WebsocketMQMessage
 * @Desc
 * @date 2019年06月24日
 * @Version V1.0
 */
@Data
public class WebsocketMQMessage implements Serializable {

    private static final long serialVersionUID = -1682484510394976762L;

    public static final Integer SOME_SEND = 0;//只对某些用户
    public static final Integer EX_SEND = 1;//排除某些用户
    public static final Integer ALL_SEND = 2;//推送全部用户

    private PushMessage pushMessage;//消息体

    private Integer type;//消息类型（针对系统） 0 只对某些用户 1 排除某些用户 2 推送全部用户

    private Set<Integer> userIdList;//用户id集合

    public WebsocketMQMessage() {
    }

    public WebsocketMQMessage(Integer type, Set<Integer> userIdList, PushMessage pushMessage) {
        this.pushMessage = pushMessage;
        this.type = type;
        this.userIdList = userIdList;

    }
}
