package com.example.sl.domain.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatDto {
    private Long id;
    private String seatNumber;
    private boolean reserved;
    private BigDecimal price; // 가격 필드 추가
}
