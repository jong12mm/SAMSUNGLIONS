package com.example.sl.domain.service;

import com.example.sl.domain.dto.PaymentDto;
import com.example.sl.entity.PaymentEntity;

public interface PaymentService {
    PaymentEntity makePayment(PaymentDto paymentDto);
    PaymentEntity cancelPayment(String payId);
}
