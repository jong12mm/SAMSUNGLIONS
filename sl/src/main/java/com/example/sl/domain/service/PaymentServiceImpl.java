package com.example.sl.domain.service;

import com.example.sl.domain.dto.PaymentDto;
import com.example.sl.entity.BookEntity;
import com.example.sl.entity.PaymentEntity;
import com.example.sl.repository.BookRepository;
import com.example.sl.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public PaymentEntity makePayment(PaymentDto paymentDto) {
        BookEntity bookEntity = bookRepository.findById(paymentDto.getBookId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid bookId"));

        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setAmount(paymentDto.getAmount());
        paymentEntity.setPaymentDateTime(LocalDateTime.now());
        paymentEntity.setPaymentMethod(paymentDto.getPaymentMethod());
        paymentEntity.setPaymentStatus("성공");
        paymentEntity.setBookEntity(bookEntity);

        return paymentRepository.save(paymentEntity);
    }

    @Override
    public PaymentEntity cancelPayment(Long paymentId) {
        PaymentEntity paymentEntity = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid paymentId"));

        paymentEntity.setPaymentStatus("실패");

        return paymentRepository.save(paymentEntity);
    }
}
