package com.sparta.calendarjpa.dto;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class CalendarSimpleResponseDto {


    private final String title;
    private final String todo;

    public CalendarSimpleResponseDto(String title, String todo) {

        this.title = title;
        this.todo = todo;
    }
}
