package com.sparta.calendarjpa.domain.manager.dto.response;

import com.sparta.calendarjpa.domain.user.dto.UserDto;
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
