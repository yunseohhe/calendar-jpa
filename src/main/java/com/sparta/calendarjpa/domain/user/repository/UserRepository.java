package com.sparta.calendarjpa.domain.user.repository;

import com.sparta.calendarjpa.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
