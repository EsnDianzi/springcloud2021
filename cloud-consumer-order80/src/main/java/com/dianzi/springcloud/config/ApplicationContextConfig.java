package com.dianzi.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/18
 */

@Configuration
public class ApplicationContextConfig {


    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
