package com.example.sl.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookid;
    private Long seatid;
    private String seat;
    private String name;
    private String gameinfo;
    private LocalDateTime date;
    private String bookstatus;
    private String payid;
    private String impUid;
    private String mainZone;  // 메인존 추가
    private String zone;      // 존 추가

    private BigDecimal totalPrice;
}