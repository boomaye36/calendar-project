package com.example.calendarapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final JavaMailSender javaMailSender;

    @GetMapping("/api/mail")
    public void sendTestMail(){
        final MimeMessagePreparator preparator = (MimeMessage message) -> {
            final MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo("32182308@dankook.ac.kr");
            helper.setSubject("안녕하세요");
            helper.setText("여기는 텍스트 내용입니다.");
        };
        javaMailSender.send(preparator);
    }
}
