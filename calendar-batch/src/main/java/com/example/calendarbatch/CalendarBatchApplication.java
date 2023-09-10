package com.example.calendarbatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class CalendarBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalendarBatchApplication.class, args);
    }

}
