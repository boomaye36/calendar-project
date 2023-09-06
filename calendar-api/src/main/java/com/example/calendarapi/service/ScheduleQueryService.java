package com.example.calendarapi.service;

import com.example.calendarapi.dto.AuthUser;
import com.example.calendarapi.dto.ScheduleDto;
import com.example.calendarapi.util.DtoConverter;
import com.example.calendarcore.domain.entity.Engagement;
import com.example.calendarcore.domain.entity.Schedule;
import com.example.calendarcore.domain.entity.repository.EngagementRepository;
import com.example.calendarcore.domain.entity.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ScheduleQueryService {
    private final ScheduleRepository scheduleRepository;
    private final EngagementRepository engagementRepository;
    public List<ScheduleDto> getScheduleByDay(AuthUser authUser, LocalDate date) {
        final Stream<ScheduleDto> schedules = scheduleRepository.findAllByWriter_Id(authUser.getId())
                .stream()
                .filter(schedule -> schedule.isOverlapped(date))
                .map(schedule -> DtoConverter.fomSchedule(schedule));
        final Stream<ScheduleDto> engagementList =
                engagementRepository.findAllByAttendee_Id(authUser.getId())
                        .stream()
                        .filter(engagement -> engagement.isOverlapped(date))
                        .map(engagement -> DtoConverter.fomSchedule(engagement.getSchedule()));

        return Stream.concat(schedules, engagementList)
                .collect(Collectors.toList());
    }
}
