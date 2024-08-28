package com.sparta.calendarjpa.repository;

import com.sparta.calendarjpa.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
