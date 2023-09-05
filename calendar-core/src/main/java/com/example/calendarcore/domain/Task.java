package com.example.calendarcore.domain;

import com.example.calendarcore.domain.entity.Schedule;
import com.example.calendarcore.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Getter
@NoArgsConstructor
public class Task {
    private Schedule schedule;

    public Task(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getTitle(){
        return schedule.getTitle();
    }
}
