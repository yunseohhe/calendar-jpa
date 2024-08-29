package com.sparta.calendarjpa.service;

import com.sparta.calendarjpa.dto.comment.reponse.CommentSaveResponseDto;
import com.sparta.calendarjpa.dto.comment.reponse.CommentDetailResponseDto;
import com.sparta.calendarjpa.dto.comment.reponse.CommentUpdateResponseDto;
import com.sparta.calendarjpa.dto.comment.request.CommentSaveRequestDto;
import com.sparta.calendarjpa.dto.comment.request.CommentUpdateRequestDto;
import com.sparta.calendarjpa.entity.Calendar;
import com.sparta.calendarjpa.entity.Comment;
import com.sparta.calendarjpa.repository.CalendarRepository;
import com.sparta.calendarjpa.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CalendarRepository calendarRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(Long calendarId, CommentSaveRequestDto requestDto) {
        Calendar calendar = calendarRepository.findById(calendarId).orElseThrow(() -> new NullPointerException("해당하는 Id가 없습니다."));

        Comment newComment = new Comment(requestDto.getContents(), requestDto.getUsername(), calendar);
        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponseDto(savedComment.getId(), savedComment.getContents(), savedComment.getUsername());
    }

    public List<CommentDetailResponseDto> getComments(Long calendarId) {
        List<Comment> commentList = commentRepository.findByCalendarId(calendarId);

        List<CommentDetailResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentDetailResponseDto dto = new CommentDetailResponseDto(comment.getId(), comment.getContents(), comment.getUsername());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public CommentDetailResponseDto getComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("댓글이 없습니다."));

        return new CommentDetailResponseDto(comment.getId(), comment.getContents(), comment.getUsername());
    }

    @Transactional
    public CommentUpdateResponseDto updateComment(Long commentId, CommentUpdateRequestDto requestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("댓글이 없습니다."));

        comment.update(requestDto.getContents());
        return new CommentUpdateResponseDto(comment.getId(), comment.getContents());
    }

    @Transactional
    public void deleteComment(Long commentId) {
        if (!commentRepository.existsById(commentId)) {
            throw new NullPointerException("댓글이 없습니다.");
        }

        commentRepository.deleteById(commentId);
    }
}




















