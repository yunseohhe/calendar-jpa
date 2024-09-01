package com.sparta.calendarjpa.domain.comment.service;

import com.sparta.calendarjpa.domain.comment.dto.reponse.CommentSaveResponseDto;
import com.sparta.calendarjpa.domain.comment.dto.reponse.CommentDetailResponseDto;
import com.sparta.calendarjpa.domain.comment.dto.reponse.CommentUpdateResponseDto;
import com.sparta.calendarjpa.domain.comment.dto.request.CommentSaveRequestDto;
import com.sparta.calendarjpa.domain.comment.dto.request.CommentUpdateRequestDto;
import com.sparta.calendarjpa.domain.user.dto.UserDto;
import com.sparta.calendarjpa.domain.calendar.entity.Calendar;
import com.sparta.calendarjpa.domain.comment.entity.Comment;
import com.sparta.calendarjpa.domain.user.entity.User;
import com.sparta.calendarjpa.domain.calendar.repository.CalendarRepository;
import com.sparta.calendarjpa.domain.comment.repository.CommentRepository;
import com.sparta.calendarjpa.domain.user.repository.UserRepository;
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
    private final UserRepository userRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(Long calendarId, CommentSaveRequestDto requestDto) {
        Calendar calendar = calendarRepository.findById(calendarId).orElseThrow(() -> new NullPointerException("해당하는 Id가 없습니다."));

        User user = userRepository.findById(requestDto.getId()).orElseThrow(() -> new NullPointerException("해당하는 유저가 없습니다."));

        Comment newComment = new Comment(requestDto.getContents(), user, calendar);
        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponseDto(savedComment.getId(), savedComment.getContents(), new UserDto(user.getId(), user.getUsername(), user.getEmail()));
    }

    public List<CommentDetailResponseDto> getComments(Long calendarId) {
        List<Comment> commentList = commentRepository.findByCalendarId(calendarId);

        List<CommentDetailResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            User user = comment.getUser();
            CommentDetailResponseDto dto = new CommentDetailResponseDto(comment.getId(), comment.getContents(), new UserDto(user.getId(), user.getUsername(), user.getEmail()));
            dtoList.add(dto);
        }
        return dtoList;
    }

    public CommentDetailResponseDto getComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("댓글이 없습니다."));

        User user = comment.getUser();


        return new CommentDetailResponseDto(comment.getId(), comment.getContents(), new UserDto(user.getId(), user.getUsername(), user.getEmail()));
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




















