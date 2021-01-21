package com.dianzi.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/21
 */

@Component
public class MyLoadBalancerImpl implements LoadBalancer {


    private AtomicInteger atomicInteger =  new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;

        do{
            current = this.atomicInteger.get();
            //2147483647 int最大值
            next = current > 2147483647 ? 0: current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));

        return next;
    }

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
