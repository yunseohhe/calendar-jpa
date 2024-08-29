package com.sparta.calendarjpa.service;

import com.sparta.calendarjpa.dto.calendar.reponse.CalendarDetailResponseDto;
import com.sparta.calendarjpa.dto.calendar.reponse.CalendarSaveResponseDto;
import com.sparta.calendarjpa.dto.calendar.reponse.CalendarUpdateResponseDto;
import com.sparta.calendarjpa.dto.calendar.request.CalendarSaveRequestDto;
import com.sparta.calendarjpa.dto.calendar.request.CalendarUpdateRequestDto;
import com.sparta.calendarjpa.entity.Calendar;
import com.sparta.calendarjpa.repository.CalendarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CalendarService {

    private final CalendarRepository calendarRepository;


    @Transactional
    public CalendarSaveResponseDto saveCalendar(CalendarSaveRequestDto requestDto) {
        Calendar newCalendar = new Calendar(requestDto.getName(), requestDto.getTitle(), requestDto.getTodo());
        Calendar saveCalendar = calendarRepository.save(newCalendar);
        return new CalendarSaveResponseDto(saveCalendar.getId(), saveCalendar.getName(), saveCalendar.getTitle(), saveCalendar.getTodo());
    }

    public CalendarDetailResponseDto getCalendar(Long calendarId) {
        Calendar calendar = calendarRepository.findById(calendarId).orElseThrow(() -> new NullPointerException("해당하는 Id가 없습니다."));

        return new CalendarDetailResponseDto(calendar.getId(), calendar.getName(), calendar.getTitle(), calendar.getTodo());
    }

    @Transactional
    public CalendarUpdateResponseDto updateCalendar(Long calendarId, CalendarUpdateRequestDto requestDto) {
        Calendar calendar = calendarRepository.findById(calendarId).orElseThrow(() -> new NullPointerException("수정할 수 있는 Id가 존재하지 않습니다."));

        calendar.update(requestDto.getTitle(), requestDto.getTodo());

        return new CalendarUpdateResponseDto(calendar.getId(), calendar.getName(), calendar.getTitle(), calendar.getTodo());
    }
}
