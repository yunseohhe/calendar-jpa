package com.sparta.calendarjpa.service;

import com.sparta.calendarjpa.dto.comment.reponse.CommentSaveResponseDto;
import com.sparta.calendarjpa.dto.comment.request.CommentSaveRequestDto;
import com.sparta.calendarjpa.entity.Calendar;
import com.sparta.calendarjpa.entity.Comment;
import com.sparta.calendarjpa.repository.CalendarRepository;
import com.sparta.calendarjpa.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CalendarRepository calendarRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(Long calendarId, CommentSaveRequestDto requestDto) {
        Calendar newcalendar = calendarRepository.findById(calendarId).orElseThrow(() -> new NullPointerException("해당하는 Id가 없습니다."));

        Comment newcomment = new Comment(requestDto.getName(), requestDto.getContents());
        Comment savedComment = commentRepository.save(newcomment);

        return new CommentSaveResponseDto(savedComment.getId(), savedComment.getName(), savedComment.getContents());
    }
}




















