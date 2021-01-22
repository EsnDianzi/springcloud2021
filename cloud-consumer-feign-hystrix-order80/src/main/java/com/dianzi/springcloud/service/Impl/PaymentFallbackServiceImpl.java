package com.dianzi.springcloud.service.Impl;

import com.dianzi.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/22
 */

@Service
public class PaymentFallbackServiceImpl implements PaymentHystrixService {
    @Override
    public String getPaymentOK(Integer id) {
        return "PaymentFallbackServiceImpl getPaymentOK  FallBack";
    }

    @Override
    public String getPaymentTimeOut(Integer id) {
        return "PaymentFallbackServiceImpl getPaymentTimeOut  FallBack";
    }
}
