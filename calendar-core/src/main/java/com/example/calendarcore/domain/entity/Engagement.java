package com.example.calendarcore.domain.entity;

import com.example.calendarcore.domain.Event;
import com.example.calendarcore.domain.RequestReplyType;
import com.example.calendarcore.domain.RequestStatus;
import com.example.calendarcore.util.Period;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
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

//    public Engagement(Schedule eventSchedule, User attendee) {
//        assert eventSchedule.getScheduleType() == ScheduleType.EVENT;
//        this.schedule = eventSchedule;
//        this.requestStatus = RequestStatus.REQUESTED;
//        this.attendee = attendee;
//    }
    public Event getEvent(){
        return schedule.toEvent();
    }

    public boolean isOverlapped(LocalDate date) {
        return this.schedule.isOverlapped(date);
    }

    public boolean isOverlapped(Period period) {
        return this.schedule.isOverlapped(period);
    }

    public Engagement reply(RequestReplyType type) {
        switch (type){
            case ACCEPT :
                this.requestStatus = RequestStatus.ACCEPTED;
                break;
            case REJECT:
                this.requestStatus = RequestStatus.REQUESTED;
                break;
        }
        return this;
    }
    public String getTitle(){
       return this.schedule.getTitle();
    }

}
