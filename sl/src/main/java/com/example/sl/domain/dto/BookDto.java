package com.example.sl.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookDto {
    private Long bookid;
    private Long seatid; // 좌석 ID 추가
    private String seat;
    private String name;
    private String gameinfoId;
    private LocalDateTime date;
    private String bookstatus;
    private String payid;
    private String mainZone;  // 메인존 추가
    private String zone;      // 존 추가
    private String impUid;
}