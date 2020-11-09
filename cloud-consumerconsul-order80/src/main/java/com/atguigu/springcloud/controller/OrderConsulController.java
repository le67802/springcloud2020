package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by chenpeng on 2020/11/3 16:15
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderConsulController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String INVOKE_URL = "http://cloud-provider-payment";

    @RequestMapping("/consul/payment")
    public String paymentInfo(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
    }
}
