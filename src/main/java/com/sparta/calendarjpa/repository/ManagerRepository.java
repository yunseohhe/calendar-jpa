package com.sparta.calendarjpa.repository;

import com.sparta.calendarjpa.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    List<Manager> findByCalendarId(Long calendarId);

}
