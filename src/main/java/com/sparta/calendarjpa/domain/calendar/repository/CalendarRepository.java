package com.sparta.calendarjpa.domain.calendar.repository;

import com.sparta.calendarjpa.domain.calendar.entity.Calendar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    Page<Calendar> findAllByOrderByModifiedAtDesc(Pageable pageable);
}
