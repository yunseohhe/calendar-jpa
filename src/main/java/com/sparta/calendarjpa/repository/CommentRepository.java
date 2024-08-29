package com.sparta.calendarjpa.repository;

import com.sparta.calendarjpa.dto.comment.reponse.CommentDetailResponseDto;
import com.sparta.calendarjpa.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByCalendarId(Long calendarId);
}
