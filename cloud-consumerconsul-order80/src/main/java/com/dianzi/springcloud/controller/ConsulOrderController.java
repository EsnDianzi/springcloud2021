package com.dianzi.springcloud.controller;

import com.dianzi.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/20
 */

@RestController
public class ConsulOrderController {

    private static final String INVOKE_URL = "http://consul-provider-payment";


    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/consul/payment")
    public Object paymentGet(){
        String res = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);

        return res;

    }
}
