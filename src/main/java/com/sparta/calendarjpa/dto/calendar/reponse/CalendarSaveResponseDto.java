package com.sparta.calendarjpa.dto.calendar.reponse;

import lombok.Getter;

@Getter
public class CalendarSaveResponseDto {

    private final String name;
    private final String title;

    public CalendarSaveResponseDto(String name, String title, String todo) {
        this.name = name;
        this.title = title;
        this.todo = todo;
    }

    private final String todo;
}
