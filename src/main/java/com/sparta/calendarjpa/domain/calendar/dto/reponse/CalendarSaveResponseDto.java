package com.sparta.calendarjpa.domain.calendar.dto.reponse;

import com.sparta.calendarjpa.domain.user.dto.UserDto;
import lombok.Getter;

@Getter
public class CalendarSaveResponseDto {

    private final Long id;
    private final String title;
    private final String todo;
    private final UserDto user;

    public CalendarSaveResponseDto(Long id, String title, String todo, UserDto user) {
        this.id = id;
        this.title = title;
        this.todo = todo;
        this.user = user;
    }

}
