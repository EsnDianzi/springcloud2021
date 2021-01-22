package com.dianzi.springcloud.service;

import com.dianzi.springcloud.service.Impl.PaymentFallbackServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/22
 */

@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackServiceImpl.class)
@Service
public interface PaymentHystrixService {

    @GetMapping("/hystrix/payment/get/{id}")
    public String getPaymentOK(@PathVariable("id") Integer id);

    @GetMapping("/hystrix/payment2/get/{id}")
    public String getPaymentTimeOut(@PathVariable("id") Integer id);
}
