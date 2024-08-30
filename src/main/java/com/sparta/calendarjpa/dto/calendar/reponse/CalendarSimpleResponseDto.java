package com.sparta.calendarjpa.dto.calendar.reponse;

import com.sparta.calendarjpa.dto.user.UserDto;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CalendarSimpleResponseDto {

    private final Long id;
    private final String title;
    private final String todo;
    private final int commentCount;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CalendarSimpleResponseDto(Long id, String title, String todo, int commentCount, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.todo = todo;
        this.commentCount = commentCount;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
