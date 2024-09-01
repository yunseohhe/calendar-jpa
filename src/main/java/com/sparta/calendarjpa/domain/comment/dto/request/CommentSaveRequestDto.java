package com.sparta.calendarjpa.domain.comment.dto.request;

import lombok.Getter;

@Getter
public class CommentSaveRequestDto {

    private String contents;
    private Long Id;
}
