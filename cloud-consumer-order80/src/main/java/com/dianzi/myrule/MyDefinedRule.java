package com.dianzi.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/21
 */

@Configuration
public class MyDefinedRule {

    @Bean
    public IRule myRule(){

        //定义为随机算法
        return new RandomRule();
    }
}
