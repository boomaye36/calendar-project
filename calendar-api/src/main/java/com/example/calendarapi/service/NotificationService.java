package com.example.calendarapi.service;

import com.example.calendarapi.dto.AuthUser;
import com.example.calendarapi.dto.NotificationCreateReq;
import com.example.calendarcore.domain.entity.Schedule;
import com.example.calendarcore.domain.entity.User;
import com.example.calendarcore.domain.entity.repository.ScheduleRepository;
import com.example.calendarcore.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final UserService userService;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public void create(NotificationCreateReq notificationCreateReq,
                       AuthUser authUser){
        final User user = userService.findByUserId(authUser.getId());
        final List<LocalDateTime> notifyAtList =  notificationCreateReq.getRepeatTimes();
        notifyAtList.forEach(notifyAt -> {
            final Schedule notificationSchedule =
                    Schedule.notification(
                            notificationCreateReq.getTitle(),
                            notifyAt,
                            user
                    );
            scheduleRepository.save(notificationSchedule);
        });

    }

}
