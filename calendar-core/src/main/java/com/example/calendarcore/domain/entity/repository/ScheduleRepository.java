package com.example.calendarcore.domain.entity.repository;

import com.example.calendarcore.domain.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
