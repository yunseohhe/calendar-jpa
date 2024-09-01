package com.sparta.calendarjpa.domain.manager.controller;

import com.sparta.calendarjpa.domain.manager.dto.request.ManagerSaveRequestDto;
import com.sparta.calendarjpa.domain.manager.dto.response.ManagerDetailResponseDto;
import com.sparta.calendarjpa.domain.manager.dto.response.ManagerSaveResponseDto;
import com.sparta.calendarjpa.domain.manager.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping("/calendars/{calendarId}/managers")
    public ResponseEntity<ManagerSaveResponseDto> saveManager(@PathVariable("calendarId") Long calendarId, @RequestBody ManagerSaveRequestDto managerSaveRequestDto) {
        return ResponseEntity.ok(managerService.saveManager(calendarId, managerSaveRequestDto));
    }

    @GetMapping("/calendars/{calendarId}/managers")
    public ResponseEntity<List<ManagerDetailResponseDto>> getManagers(@PathVariable("calendarId") Long calendarId) {
        return ResponseEntity.ok(managerService.getManagers(calendarId));
    }
}
