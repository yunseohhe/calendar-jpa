package com.sparta.calendarjpa.domain.comment.repository;

import com.sparta.calendarjpa.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByCalendarId(Long calendarId);
}
