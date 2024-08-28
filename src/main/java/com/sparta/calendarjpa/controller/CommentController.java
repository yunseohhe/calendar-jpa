package com.sparta.calendarjpa.controller;

import com.sparta.calendarjpa.dto.comment.reponse.CommentSaveResponseDto;
import com.sparta.calendarjpa.dto.comment.request.CommentSaveRequestDto;
import com.sparta.calendarjpa.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/calendars/{calendarId}/commemts")
    public CommentSaveResponseDto saveComment(@PathVariable Long calendarId, @RequestBody CommentSaveRequestDto requestDto) {
        return commentService.saveComment(calendarId, requestDto);
    }
}
