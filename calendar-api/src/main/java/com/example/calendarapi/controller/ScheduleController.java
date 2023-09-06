package com.example.calendarapi.controller;

import com.example.calendarapi.dto.AuthUser;
import com.example.calendarapi.dto.TaskCreateReq;
import com.example.calendarapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import static com.example.calendarapi.service.LoginService.LOGIN_SESSION_KEY;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<Void> createTask(
            @RequestBody TaskCreateReq taskCreateReq,
            AuthUser authUser){
        taskService.create(taskCreateReq, authUser);
        return ResponseEntity.ok().build();
    }
}
