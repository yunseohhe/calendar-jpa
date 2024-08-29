package com.sparta.calendarjpa.dto.calendar.reponse;

import lombok.Getter;

@Getter
public class CalendarSimpleResponseDto {

    private final String title;

    public CalendarSimpleResponseDto(String title) {
        this.title = title;
    }
}
