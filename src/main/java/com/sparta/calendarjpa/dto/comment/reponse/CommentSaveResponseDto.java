package com.sparta.calendarjpa.dto.comment.reponse;

import lombok.Getter;

@Getter
public class CommentSaveResponseDto {

    private final Long id;
    private final String name;
    private final String contents;

    public CommentSaveResponseDto(Long id, String name, String contents) {
        this.id = id;
        this.name = name;
        this.contents = contents;
    }
}
