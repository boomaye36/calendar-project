package com.example.calendarapi.service;

import com.example.calendarapi.dto.EngagementEmailStuff;
import com.example.calendarcore.domain.entity.Engagement;

public interface EmailService {
    void sendEngagement(EngagementEmailStuff engagementEmailStuff);
}
