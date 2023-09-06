package com.example.calendarapi.service;

import com.example.calendarapi.dto.AuthUser;
import com.example.calendarapi.dto.TaskCreateReq;
import com.example.calendarcore.domain.entity.Schedule;
import com.example.calendarcore.domain.entity.repository.ScheduleRepository;
import com.example.calendarcore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class TaskService {
    private final ScheduleRepository scheduleRepository;
    private final UserService userService;

    public void create(TaskCreateReq taskCreateReq, AuthUser authUser) {
        final Schedule taskSchedule =
                Schedule.task(taskCreateReq.getTitle(),
                        taskCreateReq.getDescription(),
                        taskCreateReq.getTaskAt(),
                        userService.findByUserId(authUser.getId()));
        scheduleRepository.save(taskSchedule);
    }
}
