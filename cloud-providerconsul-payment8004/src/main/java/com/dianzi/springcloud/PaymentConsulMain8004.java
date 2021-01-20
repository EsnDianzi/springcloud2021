package com.dianzi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/20
 */


@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain8004.class,args);
    }
}
