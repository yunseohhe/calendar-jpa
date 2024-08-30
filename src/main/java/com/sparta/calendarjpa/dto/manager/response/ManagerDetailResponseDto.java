package com.sparta.calendarjpa.dto.manager.response;

import com.sparta.calendarjpa.dto.user.UserDto;
import lombok.Getter;

@Getter
public class ManagerDetailResponseDto {

    private final Long id;
    private final UserDto user;

    public ManagerDetailResponseDto(Long id, UserDto user) {
        this.id = id;
        this.user = user;
    }
}
