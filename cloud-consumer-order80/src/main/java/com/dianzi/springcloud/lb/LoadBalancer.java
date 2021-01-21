package com.dianzi.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/21
 */
public interface LoadBalancer {

    ServiceInstance getInstance(List<ServiceInstance> serviceInstances);
}
