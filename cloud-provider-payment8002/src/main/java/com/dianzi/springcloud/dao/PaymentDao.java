package com.dianzi.springcloud.dao;

import com.dianzi.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/18
 */

@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymenById(@Param("id") Long id);
}
