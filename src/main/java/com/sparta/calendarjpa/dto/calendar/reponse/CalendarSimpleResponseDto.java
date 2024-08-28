package com.sparta.calendarjpa.dto.calendar.reponse;

import lombok.Getter;

@Getter
public class CalendarSimpleResponseDto {


    private final String title;
    private final String todo;

    public CalendarSimpleResponseDto(String title, String todo) {

        this.title = title;
        this.todo = todo;
    }
}
