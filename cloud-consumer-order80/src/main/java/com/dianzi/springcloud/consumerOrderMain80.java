package com.dianzi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/18
 */

@SpringBootApplication
@EnableEurekaClient
public class consumerOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(consumerOrderMain80.class,args);
    }
}
