package com.dianzi.springcloud.controller;

import com.dianzi.springcloud.serivce.Impl.PaymentServiceImpl;
import com.dianzi.springcloud.serivce.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/21
 */


@RestController
public class PaymentController {


    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentServiceImpl paymentServiceImpl;


    @GetMapping("/hystrix/payment/get/{id}")
    public String getPaymentOK(@PathVariable("id") Integer id) {

        return paymentService.paymentOK(id);

    }

    @GetMapping("/hystrix/payment2/get/{id}")
    public String getPaymentTimeOut(@PathVariable("id") Integer id) {

        return paymentService.paymentTimeOut(id);

    }


    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String res = paymentServiceImpl.PaymentCircuitBreaker(id);

        return res;
    }
}
