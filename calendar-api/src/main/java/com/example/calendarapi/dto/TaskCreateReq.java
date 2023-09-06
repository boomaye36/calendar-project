package com.example.calendarapi.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TaskCreateReq {
    private final String title;
    private final String description;
    private final LocalDateTime taskAt;
}
