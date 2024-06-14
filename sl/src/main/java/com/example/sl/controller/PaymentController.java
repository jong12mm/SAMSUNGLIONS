package com.example.sl.controller;

import com.example.sl.domain.dto.PaymentDto;
import com.example.sl.domain.service.PaymentService;
import com.example.sl.entity.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // 결제 생성 API
    @PostMapping("/make")
    public ResponseEntity<PaymentEntity> makePayment(@RequestBody PaymentDto paymentDto) {
        PaymentEntity paymentEntity = paymentService.makePayment(paymentDto);
        return ResponseEntity.ok(paymentEntity);
    }

    // 결제 취소 API
    @PostMapping("/cancel/{id}")
    public ResponseEntity<PaymentEntity> cancelPayment(@PathVariable("id") Long id) {
        PaymentEntity paymentEntity = paymentService.cancelPayment(id);
        return ResponseEntity.ok(paymentEntity);
    }
}
