package com.example.calendarcore.domain;

import com.example.calendarcore.domain.entity.Engagement;
import com.example.calendarcore.domain.entity.Schedule;
import com.example.calendarcore.domain.entity.User;
import com.example.calendarcore.util.Period;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
@NoArgsConstructor
@Getter

public class Event {


    private Schedule schedule;


    public Event(Schedule schedule) {
        this.schedule = schedule;
    }

    public boolean isOverlapped(LocalDateTime startAt, LocalDateTime endAt) {
        return schedule.getStartAt().isBefore(endAt) && schedule.getEndAt().isAfter(startAt);
    }

//    public void addEngagement(Engagement engagement) {
//        if (engagements == null){
//            engagements = Arrays.asList(engagement);
//        }
//        else{
//            engagements.add(engagement);
//        }
//    }
    public RequestStatus getRequestStatus(){
        return this.getRequestStatus();
    }

    public Period getPeriod() {
        return Period.of(this.schedule.getStartAt(), this.schedule.getEndAt());
    }
}
