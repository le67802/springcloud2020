package com.atguigu.springcloud.service;

/**
 * Created by chenpeng on 2020/11/4 14:32
 */
public interface PaymentService {

    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id);

    String paymentCircuitBreaker(Integer id);
}
