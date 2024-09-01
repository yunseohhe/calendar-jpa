package com.sparta.calendarjpa.domain.comment.controller;

import com.sparta.calendarjpa.domain.comment.dto.reponse.CommentSaveResponseDto;
import com.sparta.calendarjpa.domain.comment.dto.reponse.CommentDetailResponseDto;
import com.sparta.calendarjpa.domain.comment.dto.reponse.CommentUpdateResponseDto;
import com.sparta.calendarjpa.domain.comment.dto.request.CommentSaveRequestDto;
import com.sparta.calendarjpa.domain.comment.dto.request.CommentUpdateRequestDto;
import com.sparta.calendarjpa.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 저장
    @PostMapping("/calendars/{calendarId}/comments")
    public ResponseEntity<CommentSaveResponseDto> saveComment(@PathVariable("calendarId") Long calendarId, @RequestBody CommentSaveRequestDto requestDto) {
        return ResponseEntity.ok(commentService.saveComment(calendarId, requestDto));
    }

    // 전체 조회
    @GetMapping("/calendars/{calendarId}/comments")
    public ResponseEntity<List<CommentDetailResponseDto>> getComments(@PathVariable("calendarId") Long calendarId) {
        return ResponseEntity.ok(commentService.getComments(calendarId));
    }

    // 단건 조회
    @GetMapping("/calendars/comments/{commentId}")// {calendarId}를 넣는 것은 회사에 따라 다름(프론트앤드 입장에서는 일관성 있는게 좋다고 함)
    public ResponseEntity<CommentDetailResponseDto> getComment(@PathVariable("commentId") Long commentId) {
        return ResponseEntity.ok(commentService.getComment(commentId));
    }

    // 수정
    @PutMapping("/calendars/comments/{commentId}")
    public ResponseEntity<CommentUpdateResponseDto> updateComment(@PathVariable("commentId") Long commentId, @RequestBody CommentUpdateRequestDto requestDto) {
        return ResponseEntity.ok(commentService.updateComment(commentId, requestDto));
    }

    // 삭제
    @DeleteMapping("/calendars/comments/{commentId}")
    public void deleteComment(@PathVariable("commentId") Long commentId) {
        commentService.deleteComment(commentId);
    }
}
