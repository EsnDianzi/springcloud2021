package com.dianzi.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/20
 */

@RestController
public class PaymentController {


    @Value("server.port")
    private String serverPort;

    @GetMapping("/payment/zookeeper")
    public String getZookeeper(){

        return "springcloud with zookeeper: "+ serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
