package com.example.calendarcore.domain.entity;

import com.example.calendarcore.domain.Event;
import com.example.calendarcore.domain.RequestStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "engagements")
public class Engagement extends BaseEntity{


    @JoinColumn(name="schedule_id")
    @ManyToOne
    private Schedule schedule;
    @JoinColumn (name="attendee_id")
    @ManyToOne
    private User attendee;
}
