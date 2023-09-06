package com.example.calendarapi.service;

import com.example.calendarapi.dto.AuthUser;
import com.example.calendarapi.dto.EventCreateReq;
import com.example.calendarcore.domain.RequestStatus;
import com.example.calendarcore.domain.entity.Engagement;
import com.example.calendarcore.domain.entity.Schedule;
import com.example.calendarcore.domain.entity.User;
import com.example.calendarcore.domain.entity.repository.EngagementRepository;
import com.example.calendarcore.domain.entity.repository.ScheduleRepository;
import com.example.calendarcore.service.UserService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EngagementRepository engagementRepository;
    private final UserService userService;
    private final ScheduleRepository scheduleRepository;
    private final EmailService emailService;
    @Transactional
    public void create(EventCreateReq eventCreateReq, AuthUser authUser) {
        // 이벤트 참여자의 다른 이벤트와 중복이 되면 안된다.
        // 1~2까지 회의가 있는데 추가로 다른 회의를 등록할 수 없음.
        // 이메일 발송
        final List<Engagement> engagementList = engagementRepository.findAll(); // TODO -> findALL 개선
        if (engagementList.stream()
                .anyMatch(e -> eventCreateReq.getAttendeeIds().contains(e.getAttendee().getId())
                && e.getRequestStatus() == RequestStatus.ACCEPTED
                && e.getEvent().isOverlapped(
                        eventCreateReq.getStartAt(), eventCreateReq.getEndAt()
                ))){ //이미 조건에 맞는 약속이 있으면 생성 불가
            throw new RuntimeException("cannot make engagement. period overlapped");
        }
        final Schedule eventSchedule = Schedule.event(
                eventCreateReq.getTitle(),
                eventCreateReq.getDescription(),
                eventCreateReq.getStartAt(),
                eventCreateReq.getEndAt(),
                userService.findByUserId(authUser.getId())
        );
        scheduleRepository.save(eventSchedule);
        eventCreateReq.getAttendeeIds()
                .forEach(atId -> {
                    final User attendee = userService.findByUserId(atId);
                    final Engagement engagement = Engagement.builder()
                            .schedule(eventSchedule)
                            .requestStatus(RequestStatus.REQUESTED)
                            .attendee(attendee)
                            .build();
                    engagementRepository.save(engagement);
                    emailService.sendEngagement(engagement);
                });
    }
}
