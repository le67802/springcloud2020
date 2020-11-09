package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * Created by chenpeng on 2020/11/2 15:59
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
