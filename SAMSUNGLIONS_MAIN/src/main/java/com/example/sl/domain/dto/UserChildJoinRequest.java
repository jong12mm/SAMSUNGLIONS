package com.example.sl.domain.dto;

import lombok.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserChildJoinRequest {
    private String userName;
    private String password;
    private String realname;
    private LocalDate birth;
    private String adultphone;
    private String childphone;
    private String addr;
    private String email;
    private char gender;

    public void setBirth(String birth) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            this.birth = LocalDate.parse(birth, formatter);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
    }
}
