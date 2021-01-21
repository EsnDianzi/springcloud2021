package com.dianzi.springcloud;

import com.dianzi.myrule.MyDefinedRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/18
 */

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyDefinedRule.class)
public class consumerOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(consumerOrderMain80.class,args);
    }
}
