package com.example.sl.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.*;

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


}