package com.dianzi.springcloud.service.impl;

import com.dianzi.springcloud.dao.PaymentDao;
import com.dianzi.springcloud.entities.Payment;
import com.dianzi.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName springcloud2021
 * @Author DianziEsn
 * @date 2021/1/18
 */

@Service
public class PaymentServiceImpl implements PaymentService {


    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymenById(Long id) {
        return paymentDao.getPaymenById(id);
    }
}
