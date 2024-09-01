package com.sparta.calendarjpa.domain.calendar.dto.reponse;

import com.sparta.calendarjpa.domain.user.dto.UserDto;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CalendarDetailResponseDto {

    private final Long id;
    private final UserDto user;
    private final String title;
    private final String todo;
    private final int commentCount;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CalendarDetailResponseDto(Long id, UserDto user, String title, String todo, int commentCount, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.todo = todo;
        this.commentCount = commentCount;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
