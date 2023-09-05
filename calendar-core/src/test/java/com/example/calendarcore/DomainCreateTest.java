package com.example.calendarcore;

import com.example.calendarcore.domain.entity.Schedule;
import com.example.calendarcore.domain.entity.ScheduleType;
import com.example.calendarcore.domain.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class DomainCreateTest {

    @Test
    void eventCreate() {

        final User me = new User("name", "email", "pw", LocalDate.now());
        final Schedule taskSchedule = Schedule.task("할일", "운동하기", LocalDateTime.now(), me);
        Assertions.assertEquals(taskSchedule.getScheduleType(), ScheduleType.TASK);
        Assertions.assertEquals(taskSchedule.toTask().getTitle(), "할일");
    }
}