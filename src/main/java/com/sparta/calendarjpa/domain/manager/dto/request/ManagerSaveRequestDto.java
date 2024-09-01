package com.sparta.calendarjpa.domain.manager.dto.request;

import lombok.Getter;

@Getter
public class ManagerSaveRequestDto {

    private Long calendarUserId; // 일정 작성자 유저 id
    private Long managerUserId; // 일정 작성자가 배치하는 유저의 id
}
