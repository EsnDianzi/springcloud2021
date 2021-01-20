package com.dianzi.springcloud;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/15
 */

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class paymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(paymentMain8001.class,args);
    }
}
