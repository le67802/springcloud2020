package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenpeng on 2020/11/2 16:03
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        CommonResult commonResult;
        try {
          Integer result = paymentService.create(payment);
          commonResult = new CommonResult(200,"添加成功",result);
          log.info("插入成功");
        }catch (Exception e){
            commonResult = new CommonResult(500,"添加失败");
            log.error("插入失败"+e.getMessage());
        }
        return commonResult;
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        CommonResult commonResult;
        try {
            Payment payment = paymentService.getPaymentById(id);
            commonResult = new CommonResult(200,"查询成功: "+serverPort,payment);
            log.info("查询成功");
        }catch (Exception e){
            commonResult = new CommonResult(500,"查询失败");
            log.info("查询失败"+e.getMessage());
        }
        return commonResult;
    }

    @GetMapping("/discovery")
    public Object discovery(){
       List<String> services =  discoveryClient.getServices();
       for(String service:services){
           log.info("service>>>>>>"+service);
       }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
       for(ServiceInstance instance:instances){
           log.info(instance.getServiceId()+"\t"+instance.getUri()+"\t"+instance.getHost()+"\t"+instance.getPort());
       }
       return this.discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/zipkin")
    public String paymentZipkin() {
        return "hi,i`am paymentzipkin server fall back.welcome to atguigu.hahahahahhahahah";
    }
}
