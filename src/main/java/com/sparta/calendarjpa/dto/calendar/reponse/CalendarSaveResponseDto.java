package com.sparta.calendarjpa.dto.calendar.reponse;

import com.sparta.calendarjpa.dto.user.UserDto;
import com.sparta.calendarjpa.entity.User;
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
