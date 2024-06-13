package com.example.sl.entity;


// DB의 테이블 역할을 하는 클래스


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String seat;
    private String name;
    private String gameinfo;
    private LocalDateTime date;
    private String bookstatus;
    private String payid;
}
