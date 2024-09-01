package com.sparta.calendarjpa.domain.manager.service;

import com.sparta.calendarjpa.domain.manager.dto.request.ManagerSaveRequestDto;
import com.sparta.calendarjpa.domain.manager.dto.response.ManagerDetailResponseDto;
import com.sparta.calendarjpa.domain.manager.dto.response.ManagerSaveResponseDto;
import com.sparta.calendarjpa.domain.user.dto.UserDto;
import com.sparta.calendarjpa.domain.calendar.entity.Calendar;
import com.sparta.calendarjpa.domain.manager.entity.Manager;
import com.sparta.calendarjpa.domain.user.entity.User;
import com.sparta.calendarjpa.domain.calendar.repository.CalendarRepository;
import com.sparta.calendarjpa.domain.manager.repository.ManagerRepository;
import com.sparta.calendarjpa.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final UserRepository userRepository;
    private final CalendarRepository calendarRepository;

    @Transactional
    public ManagerSaveResponseDto saveManager(Long calendarId, ManagerSaveRequestDto managerSaveRequestDto) {
        // 실제로 있는 일정을 가져온다.
        Calendar calendar = calendarRepository.findById(calendarId).orElseThrow(() -> new NullPointerException("해당하는 일정이 없습니다."));
        // 등록하려고 하는 유저가 일정을 만든 사람인지 확인하면서 가져온다
        User user = userRepository.findById(managerSaveRequestDto.getCalendarUserId()).orElseThrow(() -> new NullPointerException("일정을 만든 유저가 아닙니다."));

        if (!(calendar.getUser() != null && ObjectUtils.nullSafeEquals(user.getId(), calendar.getUser().getId()))) {
            throw new NullPointerException("담당자를 등록하려고 하는 유저가 일정을 만든 유저가 아닙니다.");
        }

        // 등록하려고 하는 담당자가 실제로 존재하는 유저인지 확인하면서 가져온다.
        User manager = userRepository.findById(managerSaveRequestDto.getManagerUserId()).orElseThrow(() -> new NullPointerException("해당하는 유저가 없습니다."));

        Manager newManager = new Manager(manager, calendar);
        Manager savedManager = managerRepository.save(newManager);

        return new ManagerSaveResponseDto(savedManager.getId());
    }

    public List<ManagerDetailResponseDto> getManagers(Long calendarId) {
        Calendar calendar = calendarRepository.findById(calendarId).orElseThrow(() -> new NullPointerException("해당하는 일정이 없습니다."));

        List<Manager> managerList = managerRepository.findByCalendarId(calendarId);

        List<ManagerDetailResponseDto> dtoList = new ArrayList<>();
        for (Manager manager : managerList) {
            User user = manager.getUser();
            dtoList.add(new ManagerDetailResponseDto(manager.getId(), new UserDto(user.getId(), user.getUsername(), user.getEmail())
            ));
        }
        return dtoList;
    }
}
