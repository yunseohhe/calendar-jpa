package com.sparta.calendarjpa.dto.calendar.request;

import lombok.Getter;

@Getter
public class CalendarSaveRequestDto {

    private Long userId;
    private String title;
    private String todo;
}
