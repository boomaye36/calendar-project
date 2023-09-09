package com.example.calendarapi.service;

import com.example.calendarapi.dto.EngagementEmailStuff;
import com.example.calendarcore.domain.entity.Engagement;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("test")
@Service
public class FakeEmailService implements EmailService{
    @Override
    public void sendEngagement(EngagementEmailStuff engagement) {
        System.out.println("send email. email : " + engagement.getSubject());

    }
}
