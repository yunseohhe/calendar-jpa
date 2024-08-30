package com.sparta.calendarjpa.dto.calendar.reponse;

import com.sparta.calendarjpa.dto.user.UserDto;
import lombok.Getter;

@Getter
public class CalendarUpdateResponseDto {

    private final Long id;
    private final UserDto user;
    private final String title;
    private final String todo;

    public CalendarUpdateResponseDto(Long id, UserDto user, String title, String todo) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.todo = todo;
    }
}
