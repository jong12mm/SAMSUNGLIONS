package com.example.sl.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String paymentId; // 결제번호
    @ManyToOne
    @JoinColumn(name = "bookid")
    private BookEntity bookEntity;      // 예매번호 (외래키)
    private BigDecimal amount; // 결제 금액
    private String paymentMethod; // 결제 방법
    private LocalDateTime paymentDateTime; // 결제 날짜/시간
    private String paymentStatus; // 결제 상태 (성공/실패)


}
