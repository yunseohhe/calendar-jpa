package com.sparta.calendarjpa.domain.calendar.service;

import com.sparta.calendarjpa.domain.calendar.dto.reponse.CalendarDetailResponseDto;
import com.sparta.calendarjpa.domain.calendar.dto.reponse.CalendarSaveResponseDto;
import com.sparta.calendarjpa.domain.calendar.dto.reponse.CalendarSimpleResponseDto;
import com.sparta.calendarjpa.domain.calendar.dto.reponse.CalendarUpdateResponseDto;
import com.sparta.calendarjpa.domain.calendar.dto.request.CalendarSaveRequestDto;
import com.sparta.calendarjpa.domain.calendar.dto.request.CalendarUpdateRequestDto;
import com.sparta.calendarjpa.domain.user.dto.UserDto;
import com.sparta.calendarjpa.domain.calendar.entity.Calendar;
import com.sparta.calendarjpa.domain.user.entity.User;
import com.sparta.calendarjpa.domain.calendar.repository.CalendarRepository;
import com.sparta.calendarjpa.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CalendarService {

    private final CalendarRepository calendarRepository;
    private final UserRepository userRepository;


    @Transactional
    public CalendarSaveResponseDto saveCalendar(CalendarSaveRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getUserId()).orElseThrow(() -> new NullPointerException("해당하는 유저가 없습니다."));

        Calendar newCalendar = new Calendar(user, requestDto.getTitle(), requestDto.getTodo());
        Calendar saveCalendar = calendarRepository.save(newCalendar);
        return new CalendarSaveResponseDto(
                saveCalendar.getId(),
                saveCalendar.getTitle(),
                saveCalendar.getTodo(),
                new UserDto(user.getId(), user.getUsername(), user.getEmail()));
    }

    public Page<CalendarSimpleResponseDto> getCalendars(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        Page<Calendar> calendars = calendarRepository.findAllByOrderByModifiedAtDesc(pageable);

        return calendars.map(calendar -> new CalendarSimpleResponseDto(
                        calendar.getId(),
                        calendar.getTitle(),
                        calendar.getTodo(),
                        calendar.getComments().size(),
                        calendar.getCreatedAt(),
                        calendar.getModifiedAt()
                )
        );
    }

    public CalendarDetailResponseDto getCalendar(Long calendarId) {
        Calendar calendar = calendarRepository.findById(calendarId).orElseThrow(() -> new NullPointerException("해당하는 Id가 없습니다."));

        User user = calendar.getUser();

        return new CalendarDetailResponseDto(
                calendar.getId(),
                new UserDto(user.getId(), user.getUsername(), user.getEmail()),
                calendar.getTitle(),
                calendar.getTodo(),
                calendar.getComments().size(),
                calendar.getCreatedAt(),
                calendar.getModifiedAt());
    }


    @Transactional
    public CalendarUpdateResponseDto updateCalendar(Long calendarId, CalendarUpdateRequestDto requestDto) {
        Calendar calendar = calendarRepository.findById(calendarId).orElseThrow(() -> new NullPointerException("수정할 수 있는 Id가 존재하지 않습니다."));

        calendar.update(requestDto.getTitle(), requestDto.getTodo());
        User user = calendar.getUser();
        return new CalendarUpdateResponseDto(calendar.getId(), new UserDto(user.getId(), user.getUsername(), user.getEmail()), calendar.getTitle(), calendar.getTodo());
    }

    @Transactional
    public void deleteCalendar(Long calendarId) {
        if (!calendarRepository.existsById(calendarId)) {
            throw new NullPointerException("해당하는 Id가 없습니다.");
        }

        calendarRepository.deleteById(calendarId);
    }


}
