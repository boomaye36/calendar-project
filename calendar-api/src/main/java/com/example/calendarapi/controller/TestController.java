package com.example.calendarapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class TestController {
    private final JavaMailSender javaMailSender;

    @GetMapping("/api/mail")
    @ResponseBody
    public void sendTestMail(){
        final MimeMessagePreparator preparator = (MimeMessage message) -> {
            final MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo("32182308@dankook.ac.kr");
            helper.setSubject("안녕하세요");
            helper.setText("여기는 텍스트 내용입니다.");
        };
        javaMailSender.send(preparator);
    }

    @GetMapping("/test/template")
    public String testTemplate(Model model){
        final Map<String, Object> props = new HashMap<>();
        props.put("title", "타이틀");
        props.put("calendar", "32182308@dankook.ac.kr");
        props.put("period", "기간");
        props.put("attendees", List.of("test1@mail.com", "test2@mail.com", "test3@mail.com"));
        props.put("acceptUrl", "http://localhost:8080");
        props.put("rejectUrl", "http://localhost:8080");
        model.addAllAttributes(props);
        return "engagement-email";

    }
}
