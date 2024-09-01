package com.sparta.calendarjpa.domain.manager.repository;

import com.sparta.calendarjpa.domain.manager.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    List<Manager> findByCalendarId(Long calendarId);

}
