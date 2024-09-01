package com.sparta.calendarjpa.domain.calendar.controller;

import com.sparta.calendarjpa.domain.calendar.dto.reponse.CalendarDetailResponseDto;
import com.sparta.calendarjpa.domain.calendar.dto.reponse.CalendarSaveResponseDto;
import com.sparta.calendarjpa.domain.calendar.dto.reponse.CalendarSimpleResponseDto;
import com.sparta.calendarjpa.domain.calendar.dto.reponse.CalendarUpdateResponseDto;
import com.sparta.calendarjpa.domain.calendar.dto.request.CalendarSaveRequestDto;
import com.sparta.calendarjpa.domain.calendar.dto.request.CalendarUpdateRequestDto;
import com.sparta.calendarjpa.domain.calendar.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CalendarController {

    private final CalendarService calendarService;

    // 일정 저장
    @PostMapping("/calendars")
    public ResponseEntity<CalendarSaveResponseDto> saveCalendar(@RequestBody CalendarSaveRequestDto requestDto) {
        return ResponseEntity.ok(calendarService.saveCalendar(requestDto));
    }

    // 일정 페이징 조회
    @GetMapping("/calendars")
    public ResponseEntity<Page<CalendarSimpleResponseDto>> getCalendars(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(calendarService.getCalendars(page, size));
    }

    // 일정 단건 조회
    @GetMapping("/calendars/{calendarId}")
    public ResponseEntity<CalendarDetailResponseDto> getCalendar(@PathVariable("calendarId") Long calendarId) {
        return ResponseEntity.ok(calendarService.getCalendar(calendarId));
    }

    // 일정 수정
    @PutMapping("/calendars/{calendarId}")
    public ResponseEntity<CalendarUpdateResponseDto> updateCalendar(@PathVariable("calendarId") Long calendarId, @RequestBody CalendarUpdateRequestDto requestDto) {
        return ResponseEntity.ok(calendarService.updateCalendar(calendarId, requestDto));
    }

    @DeleteMapping("/calendars/{calendarId}")
    public void deleteCalendar(@PathVariable Long calendarId) {
        calendarService.deleteCalendar(calendarId);
    }
}
