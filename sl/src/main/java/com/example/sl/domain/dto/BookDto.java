package com.example.sl.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookDto {
    private String bookid;
    private String seat;
    private String name;
    private String gameinfoId;
    private LocalDateTime date;
    private String bookstatus;
    private String payid;
}
