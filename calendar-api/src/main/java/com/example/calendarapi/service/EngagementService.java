package com.example.calendarapi.service;

import com.example.calendarapi.dto.AuthUser;
import com.example.calendarcore.domain.RequestReplyType;
import com.example.calendarcore.domain.RequestStatus;
import com.example.calendarcore.domain.entity.repository.EngagementRepository;
import com.example.calendarcore.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EngagementService {
    private final EngagementRepository engagementRepository;
    @Transactional
    public RequestStatus update(AuthUser authUser, Long engagementId, RequestReplyType type) {
        // engagement 조회
        // 참석자가 auth user와 같은지 비교
        // requested 상태인지 체크
        // update

        return engagementRepository.findById(engagementId)
                .filter(e -> e.getRequestStatus() == RequestStatus.REQUESTED)
                .filter(e -> e.getAttendee().getId().equals(authUser.getId()))
                .map(e -> e.reply(type))
                .orElseThrow(() -> new ClassCastException())
                .getRequestStatus();
    }
}
