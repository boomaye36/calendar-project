package com.example.calendarbatch.job;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SendMailBatchReq {
    private Long id; // schedule id
    private LocalDateTime startAt;
    private String title;
    private String userMail;
}
