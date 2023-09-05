package com.example.calendarcore.domain;

import com.example.calendarcore.domain.entity.Schedule;
import com.example.calendarcore.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor

@Getter
public class Notification {
    private Schedule schedule;

    public Notification(Schedule schedule) {
        this.schedule = schedule;
    }
}
