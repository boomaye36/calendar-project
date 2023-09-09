package com.example.calendarapi.dto;

import lombok.Data;
import net.bytebuddy.asm.Advice;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class EventCreateReq {
    @NotBlank
    private final String title;
    private final String description;
    @NotBlank
    private final LocalDateTime startAt;
    @NotBlank
    private final LocalDateTime endAt;
    private final List<Long> attendeeIds;

}
