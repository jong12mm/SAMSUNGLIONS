package com.example.sl.domain.dto;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private String bookid;
    private String seat;
    private String name;
    private String gameInfoId;
    private LocalDateTime bookCreatedTime;
    private LocalDateTime bookUpdatedTime;
    private String bookstatus;
    private String payid;




}
