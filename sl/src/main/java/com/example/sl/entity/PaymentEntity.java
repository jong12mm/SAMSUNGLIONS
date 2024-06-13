package com.example.sl.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "payment_entity")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId; // Long 타입으로 변경

    private BigDecimal amount;
    private LocalDateTime paymentDateTime;
    private String paymentMethod;
    private String paymentStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookid")
    private BookEntity bookEntity;

    // getters and setters
}
