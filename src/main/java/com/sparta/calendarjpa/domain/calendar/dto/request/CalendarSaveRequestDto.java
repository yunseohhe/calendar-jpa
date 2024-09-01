package com.sparta.calendarjpa.domain.calendar.dto.request;

import lombok.Getter;

@Getter
public class CalendarSaveRequestDto {

    private Long userId;
    private String title;
    private String todo;
}
