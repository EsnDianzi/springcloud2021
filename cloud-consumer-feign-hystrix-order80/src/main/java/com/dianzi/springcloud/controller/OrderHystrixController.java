package com.dianzi.springcloud.controller;

import com.dianzi.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/22
 */

@RestController
@DefaultProperties(defaultFallback = "getPaymentGlobalFallBack")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/hystrix/payment/get/{id}")
    public String getPaymentOK(@PathVariable("id") Integer id){

        return paymentHystrixService.getPaymentOK(id);

    }


    @GetMapping("/consumer/hystrix/payment2/get/{id}")
    @HystrixCommand
//    @HystrixCommand(fallbackMethod = "getPaymentTimeOutFallBack", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
//    })
    public String getPaymentTimeOut(@PathVariable("id") Integer id){
        int i = 10 / 0;
        return paymentHystrixService.getPaymentTimeOut(id);
    }

    public String getPaymentTimeOutFallBack(@PathVariable("id") Integer id){

        return "80服务：对方服务（8005）系统繁忙或80服务异常，请稍后再试";
    }

    public String  getPaymentGlobalFallBack(){
        return "80服务: 统一FallBack处理";
    }

}
