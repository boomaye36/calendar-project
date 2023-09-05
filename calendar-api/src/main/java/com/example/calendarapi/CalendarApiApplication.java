package com.example.calendarapi;

import com.example.calendarcore.core.SimpleEntity;
import com.example.calendarcore.core.SimpleEntityRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@EntityScan("com.example.calendarcore") // com.example.calendarcore 패키지 스캔 설정
@EnableJpaRepositories("com.example.calendarcore") // com.example.calendar
@EnableJpaAuditing
public class CalendarApiApplication {

    private final SimpleEntityRepository repository;

    public CalendarApiApplication(SimpleEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<SimpleEntity> findAll(){
        return repository.findAll();
    }

    @PostMapping("/save")
    public SimpleEntity saveOne(){
        final SimpleEntity e = new SimpleEntity();
        e.setName("hello");
        return repository.save(e);
    }

    public static void main(String[] args) {
        SpringApplication.run(CalendarApiApplication.class, args);
    }

}
