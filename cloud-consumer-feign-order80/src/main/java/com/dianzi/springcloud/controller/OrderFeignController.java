package com.dianzi.springcloud.controller;

import com.dianzi.springcloud.entities.CommonResult;
import com.dianzi.springcloud.entities.Payment;
import com.dianzi.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/21
 */

@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;


    @GetMapping("/consumer/feign/payment/get/{id}")
    public CommonResult<Payment> getFeignPayment(@PathVariable("id")Long id ){
        CommonResult payment = paymentFeignService.getPayment(id);

        return  payment;
    }
}
