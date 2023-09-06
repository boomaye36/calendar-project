package com.example.calendarapi.util;

import com.example.calendarapi.dto.EventDto;
import com.example.calendarapi.dto.NotificationDto;
import com.example.calendarapi.dto.ScheduleDto;
import com.example.calendarapi.dto.TaskDto;
import com.example.calendarcore.domain.entity.Schedule;

public abstract class DtoConverter {
    public static ScheduleDto fomSchedule(Schedule schedule){
        switch (schedule.getScheduleType()){
            case EVENT :
                return EventDto.builder()
                        .scheduleId(schedule.getId())
                        .description(schedule.getDescription())
                        .startAt(schedule.getStartAt())
                        .endAt(schedule.getEndAt())
                        .title(schedule.getTitle())
                        .writerId(schedule.getWriter().getId())
                        .build();

            case TASK:
                return TaskDto.builder()
                        .scheduleId(schedule.getId())
                        .taskAt(schedule.getStartAt())
                        .description(schedule.getDescription())
                        .writerId(schedule.getWriter().getId())
                        .title(schedule.getTitle())
                        .build();
            case NOTIFICATION:
                return NotificationDto.builder()
                        .notifyAt(schedule.getStartAt())
                        .scheduleId(schedule.getId())
                        .title(schedule.getTitle())
                        .build();
            default:
                throw new RuntimeException("bad request. not matched schedule type");
        }
    }
}
