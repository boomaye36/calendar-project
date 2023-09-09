package com.example.calendarapi.dto;

import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Data
public class SignUpReq {
    @NotBlank // " " 까지 처리
    private final String name;
    @NotBlank
    @Email
    private final String email;
    @NotBlank
    @Size(min = 6, message = "6자리 이상 입력해 주세요.")
    private final String password;
    @NonNull
    private final LocalDate birthday;

}
