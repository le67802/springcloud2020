package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenpeng on 2020/11/6 17:37
 */
@RestController
public class SendMessageController {

    @Autowired
    private IMessageService messageService;

    @RequestMapping("/sendMessage")
    public String sendMessage() {
        return messageService.send();
    }
}
