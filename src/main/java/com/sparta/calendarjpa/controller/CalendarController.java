package com.sparta.calendarjpa.controller;

import com.sparta.calendarjpa.dto.*;
import com.sparta.calendarjpa.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CalendarController {

    private final CalendarService calendarService;

    // 일정 저장
    @PostMapping("/calendars")
    public ResponseEntity<CalendarSaveResponseDto> saveCalendar(@RequestBody CalendarSaveRequestDto requestDto) {
        return ResponseEntity.ok(calendarService.saveCalendar(requestDto));
    }

    // 일정 모두 조회
    @GetMapping("/calendars")
    public ResponseEntity<List<CalendarSimpleResponseDto>> getCalendars() {
        return ResponseEntity.ok(calendarService.getCalendars());
    }

    // 일정 단건 조회
    @GetMapping("/calendars/{calendarId}")
    public ResponseEntity<CalendarDetailResponseDto> getCalendar(@PathVariable("calendarId") Long calendarId) {
        return ResponseEntity.ok(calendarService.getCalendar(calendarId));
    }

    // 일정 수정
    @PutMapping("/calendars/{calendarId}")
    public CalendarUpdateResponseDto updateCalendar(@PathVariable("calendarId") Long calendarId, @RequestBody CalendarUpdateRequestDto requestDto) {
        return calendarService.updateCalendar(calendarId, requestDto);
    }
}
