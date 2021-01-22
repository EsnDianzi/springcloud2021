package com.dianzi.springcloud.serivce.Impl;

import cn.hutool.core.util.IdUtil;
import com.dianzi.springcloud.serivce.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/21
 */

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentOK(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " paymentOK,id = " + id + "\t" + "OK";
    }


    /*=======================================================服务降级====================================================*/

    /**
     * 定义兜底fallback方法 paymentTimeOutHandler，定义方法自身调用超时时间的峰值为3000ms，
     * 超过了峰值的请求将使用fallback方法处理
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    @Override
    public String paymentTimeOut(Integer id) {

        //配置超时时间
        int timeSec = 3;

//        int test = timeSec / 0;

        //睡眠3s
        try {
            TimeUnit.SECONDS.sleep(timeSec);

        } catch (InterruptedException e) {
            e.printStackTrace();

        }

        return "线程池： " + Thread.currentThread().getName() + " paymentTimeOut,id = " + id + "\t" + "TimeOUT";
    }

    //定义fallback兜底方法处理
    public String paymentTimeOutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " 程序异常或有错误请稍后再试,id = " + id + "\t" + "FALLBACK 处理";
    }


    /*=======================================================服务熔断====================================================*/

    /**
     * circuitBreaker.enabled:是否开启断路器
     * circuitBreaker.requestVolumeThreshold：请求次数
     * circuitBreaker.sleepWindowInMilliseconds：时间窗口期
     * circuitBreaker.errorThresholdPercentage：允许失败率，超出后服务熔断
     *
     * 配置的含义是：打开熔断机制，在1000毫秒（10s）内，发送10次请求，当失败率达到60%时，启动熔断
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "PaymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public String PaymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("PaymentCircuitBreaker id 不能为负数");
        }

        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号： " + serialNumber;

    }

    public String PaymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能为负数，请稍后重试";

    }

}
