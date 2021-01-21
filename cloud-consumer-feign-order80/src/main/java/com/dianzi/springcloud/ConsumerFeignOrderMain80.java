package com.dianzi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/21
 */

@SpringBootApplication
//支持使用OpenFeign
@EnableFeignClients
public class ConsumerFeignOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignOrderMain80.class,args);
    }
}
