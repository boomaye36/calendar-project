package com.example.calendarcore.domain.entity;

import com.example.calendarcore.domain.Event;
import com.example.calendarcore.domain.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "engagements")
@Builder
@AllArgsConstructor
public class Engagement extends BaseEntity{


    @JoinColumn(name="schedule_id")
    @ManyToOne
    private Schedule schedule;
    @JoinColumn (name="attendee_id")
    @ManyToOne
    private User attendee;
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;
    public Event getEvent(){
        return schedule.toEvent();
    }
}
