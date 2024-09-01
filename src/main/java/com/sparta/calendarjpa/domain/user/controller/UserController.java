package com.sparta.calendarjpa.domain.user.controller;

import com.sparta.calendarjpa.domain.user.dto.reponse.UserSaveResponseDto;
import com.sparta.calendarjpa.domain.user.dto.reponse.UserDetailResponseDto;
import com.sparta.calendarjpa.domain.user.dto.reponse.UserSimpleResponseDto;
import com.sparta.calendarjpa.domain.user.dto.request.UserSaveRequestDto;
import com.sparta.calendarjpa.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserSaveResponseDto> saveUser(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        return ResponseEntity.ok(userService.saveUser(userSaveRequestDto));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserSimpleResponseDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDetailResponseDto> getUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }
}
