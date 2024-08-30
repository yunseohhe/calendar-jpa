package com.sparta.calendarjpa.dto.comment.reponse;

import com.sparta.calendarjpa.dto.user.UserDto;
import lombok.Getter;

@Getter
public class CommentDetailResponseDto {

    private final Long id;
    private final String contents;
    private final UserDto user;

    public CommentDetailResponseDto(Long id, String contents, UserDto user) {
        this.id = id;
        this.contents = contents;
        this.user = user;
    }
}
