package com.example.calendarcore.domain.entity.repository;

import com.example.calendarcore.domain.entity.Engagement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngagementRepository extends JpaRepository<Engagement, Long> {
}
