package com.sparta.calendarjpa.repository;

import com.sparta.calendarjpa.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
}
