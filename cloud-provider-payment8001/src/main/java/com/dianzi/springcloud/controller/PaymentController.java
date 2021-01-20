package com.dianzi.springcloud.controller;

import com.alibaba.druid.sql.visitor.functions.Isnull;
import com.dianzi.springcloud.entities.CommonResult;
import com.dianzi.springcloud.entities.Payment;
import com.dianzi.springcloud.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/18
 */


@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    //读取application.yml中的server.port信息
    @Value("${server.port}")
    private String serverPort;


    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {

        Payment payment = paymentService.getPaymenById(id);

        log.info("******查询结果：" + payment.toString() + "*******");

        if (payment != null) {
            return new CommonResult(200, "查询成功，端口为"+serverPort, payment);
        } else {
            return new CommonResult(404, "没有此记录，查询ID" + id, null);
        }


    }


    @PostMapping("/payment/create")
    public CommonResult createPayment(@RequestBody Payment payment){
        int res = paymentService.create(payment);

        log.info("*******插入payment数据"+ res);
        log.info("test222");


        if(res > 0){
            return new CommonResult(200,"插入数据成功",res);
        }else{
            return new CommonResult(500,"数据插入失败",payment);
        }

    }



    @GetMapping("/payment/discovery")
    public CommonResult getDiscovery(){

        HashMap<String, Object> resMap = new HashMap<>();
        List<String> services = discoveryClient.getServices();

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {

            resMap.put("instanceIP"+instance.getUri(),instance.getHost()
                    +instance.getInstanceId()+
                    instance.getScheme()+
                    instance.getServiceId()+
                    instance.getMetadata()+
                    instance.getPort()+
                    instance.getUri());
        }

        if(!services.isEmpty()){

            resMap.put("services",services);

            return new CommonResult(200,"Discovery请求成功",resMap);
        }else{
            return new CommonResult(404,"服务详细信息请求失败",null);
        }

    }
}
