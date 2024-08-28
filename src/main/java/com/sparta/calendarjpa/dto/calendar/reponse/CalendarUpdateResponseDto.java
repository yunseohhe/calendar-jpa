package com.sparta.calendarjpa.dto.calendar.reponse;

import lombok.Getter;

@Getter
public class CalendarUpdateResponseDto {

    private final Long id;
    private final String name;
    private final String title;
    private final String todo;

    public CalendarUpdateResponseDto(Long id, String name, String title, String todo) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.todo = todo;
    }
}
