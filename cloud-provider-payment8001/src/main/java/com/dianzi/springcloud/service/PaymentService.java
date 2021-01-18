package com.dianzi.springcloud.service;

import com.dianzi.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/18
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymenById(@Param("id") Long id);
}
