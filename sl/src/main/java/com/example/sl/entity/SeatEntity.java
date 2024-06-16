package com.example.sl.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class SeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatid;
    private String seatNumber;
    private boolean reserved;
    private BigDecimal price; // 가격 필드 추가
}
