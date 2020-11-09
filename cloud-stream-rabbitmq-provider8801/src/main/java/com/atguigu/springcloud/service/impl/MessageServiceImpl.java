package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Created by chenpeng on 2020/11/6 17:16
 */
@EnableBinding(Source.class)
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private MessageChannel output;  //消息发送通道

    @Override
    public String send() {
        String serial = IdUtil.simpleUUID();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***********serial:"+serial);
        return serial;
    }
}
