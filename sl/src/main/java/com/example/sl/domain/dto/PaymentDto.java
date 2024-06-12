package com.example.sl.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private String bookid;
    private BigDecimal amount;
    private String paymentMethod;

}
