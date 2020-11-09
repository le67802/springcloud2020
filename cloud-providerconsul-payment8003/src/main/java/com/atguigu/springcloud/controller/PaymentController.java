package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by chenpeng on 2020/11/3 16:00
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/consul")
    public String paymentConsul() {
        return "SpringCloud with consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
