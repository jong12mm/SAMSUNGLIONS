package com.example.sl.domain.service;

import com.example.sl.domain.dto.PaymentDto;
import com.example.sl.entity.BookEntity;
import com.example.sl.entity.PaymentEntity;
import com.example.sl.repository.BookRepository;
import com.example.sl.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public PaymentEntity makePayment(PaymentDto paymentDto) {
        // PaymentDTO에서 필요한 정보를 추출하여 Payment 객체 생성
        PaymentEntity paymentEntity = new PaymentEntity();
        // reservationId를 사용하여 실제 Reservation 객체를 조회하고 연결
        BookEntity reservation = bookRepository.findById(Long.valueOf(paymentDto.getBookid()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid bookid"));
        paymentEntity.setBookEntity(paymentEntity.getBookEntity());
        paymentEntity.setAmount(paymentDto.getAmount());
        paymentEntity.setPaymentMethod(paymentDto.getPaymentMethod());
        paymentEntity.setPaymentDateTime(LocalDateTime.now());
        paymentEntity.setPaymentStatus("성공");

        // 결제 정보 저장
        return paymentRepository.save(paymentEntity);
    }

    @Override
    public PaymentEntity cancelPayment(String paymentId) {
        // paymentId를 사용하여 결제 정보를 조회
        PaymentEntity paymentEntity = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid paymentId"));

        // 결제 상태를 "실패"로 변경
        paymentEntity.setPaymentStatus("실패");

        // 변경된 결제 정보 저장
        paymentRepository.save(paymentEntity);

        return paymentEntity;
    }
}