package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * Created by chenpeng on 2020/11/4 16:46
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务器出错或服务繁忙，请稍后重试";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "服务宕机，请稍后再试";
    }
}
