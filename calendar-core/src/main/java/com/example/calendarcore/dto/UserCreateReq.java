package com.example.calendarcore.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class UserCreateReq {
    private final String name;
    private final String email;
    private final String password;
    private final LocalDate birthday;
}
