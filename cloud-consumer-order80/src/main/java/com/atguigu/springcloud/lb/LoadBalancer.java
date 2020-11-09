package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chenpeng on 2020/11/3 18:54
 */
@Component
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
