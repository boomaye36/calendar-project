package com.example.calendarapi.service;

import com.example.calendarcore.domain.entity.Engagement;

public interface EmailService {
    void sendEngagement(Engagement engagement);
}
