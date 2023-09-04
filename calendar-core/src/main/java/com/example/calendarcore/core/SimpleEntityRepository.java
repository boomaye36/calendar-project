package com.example.calendarcore.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleEntityRepository extends JpaRepository<SimpleEntity, Long> {
}
