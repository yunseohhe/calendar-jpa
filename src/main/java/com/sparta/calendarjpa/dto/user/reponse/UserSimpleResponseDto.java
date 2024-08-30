package com.sparta.calendarjpa.dto.user.reponse;

import lombok.Getter;

@Getter
public class UserSimpleResponseDto {

    private final Long id;
    private final String username;

    public UserSimpleResponseDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
