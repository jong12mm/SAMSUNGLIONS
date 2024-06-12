package com.example.sl.domain.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatDto {
    private Long id;
    private String seatNumber;
    private boolean reserved;

}
