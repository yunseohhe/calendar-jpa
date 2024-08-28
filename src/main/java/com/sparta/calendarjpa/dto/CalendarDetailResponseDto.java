package com.sparta.calendarjpa.dto;

import lombok.Getter;

@Getter
public class CalendarDetailResponseDto {

    private final Long id;
    private final String name;
    private final String title;
    private final String todo;

    public CalendarDetailResponseDto(Long id, String name, String title, String todo) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.todo = todo;
    }
}
