package com.sparta.calendarjpa.controller;

import com.sparta.calendarjpa.dto.manager.request.ManagerSaveRequestDto;
import com.sparta.calendarjpa.dto.manager.response.ManagerDetailResponseDto;
import com.sparta.calendarjpa.dto.manager.response.ManagerSaveResponseDto;
import com.sparta.calendarjpa.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
