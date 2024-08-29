package com.sparta.calendarjpa.controller;

import com.sparta.calendarjpa.dto.comment.reponse.CommentSaveResponseDto;
import com.sparta.calendarjpa.dto.comment.reponse.CommentDetailResponseDto;
import com.sparta.calendarjpa.dto.comment.reponse.CommentUpdateResponseDto;
import com.sparta.calendarjpa.dto.comment.request.CommentSaveRequestDto;
import com.sparta.calendarjpa.dto.comment.request.CommentUpdateRequestDto;
import com.sparta.calendarjpa.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 저장
    @PostMapping("/calendars/{calendarId}/comments")
    public CommentSaveResponseDto saveComment(@PathVariable("calendarId") Long calendarId, @RequestBody CommentSaveRequestDto requestDto) {
        return commentService.saveComment(calendarId, requestDto);
    }

    // 전체 조회
    @GetMapping("/calendars/{calendarId}/comments")
    public List<CommentDetailResponseDto> getComments(@PathVariable("calendarId") Long calendarId) {
        return commentService.getComments(calendarId);
    }

    // 단건 조회
    @GetMapping("/calendars/comments/{commentId}")// {calendarId}를 넣는 것은 회사에 따라 다름(프론트앤드 입장에서는 일관성 있는게 좋다고 함)
    public CommentDetailResponseDto getComment(@PathVariable("commentId") Long commentId) {
        return commentService.getComment(commentId);
    }

    // 수정
    @PutMapping("/calendars/comments/{commentId}")
    public CommentUpdateResponseDto updateComment(@PathVariable("commentId") Long commentId, @RequestBody CommentUpdateRequestDto requestDto) {
        return commentService.updateComment(commentId, requestDto);
    }

    // 삭제
    @DeleteMapping("/calendars/comments/{commentId}")
    public void deleteComment(@PathVariable("commentId") Long commentId) {
        commentService.deleteComment(commentId);
    }
}
