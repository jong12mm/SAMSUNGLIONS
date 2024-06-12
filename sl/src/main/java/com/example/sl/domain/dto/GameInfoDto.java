package com.example.sl.domain.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameInfoDto {
    private int gameInfoId;
    private String gameName;
    private String stadium;
    private LocalDateTime startTime;

}
