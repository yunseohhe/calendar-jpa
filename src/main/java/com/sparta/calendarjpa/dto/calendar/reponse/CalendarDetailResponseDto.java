package com.sparta.calendarjpa.dto.calendar.reponse;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CalendarDetailResponseDto {

    private final Long id;
    private final String name;
    private final String title;
    private final String todo;
    private final int commentCount;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CalendarDetailResponseDto(Long id, String name, String title, String todo, int commentCount, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.todo = todo;
        this.commentCount = commentCount;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
