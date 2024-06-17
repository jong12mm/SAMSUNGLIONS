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
    private String seat_number;
    private String zone; // 구역 필드 추가
    private boolean reserved;
    private BigDecimal price;
}
