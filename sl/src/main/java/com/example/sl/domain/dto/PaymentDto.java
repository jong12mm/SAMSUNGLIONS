package com.example.sl.domain.dto;

import com.example.sl.entity.BookEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private String bookid;
    private BigDecimal amount;
    private LocalDateTime paymentDateTime;
    private String paymentMethod;
    private String paymentStatus;
    private BookEntity bookEntity;
}
