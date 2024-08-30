package com.sparta.calendarjpa.service;

import com.sparta.calendarjpa.dto.user.reponse.UserDetailResponseDto;
import com.sparta.calendarjpa.dto.user.reponse.UserSaveResponseDto;
import com.sparta.calendarjpa.dto.user.reponse.UserSimpleResponseDto;
import com.sparta.calendarjpa.dto.user.request.UserSaveRequestDto;
import com.sparta.calendarjpa.entity.User;
import com.sparta.calendarjpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserSaveResponseDto saveUser(UserSaveRequestDto userSaveRequestDto) {

        if (userRepository.existsByEmail(userSaveRequestDto.getEmail())) {
            throw new IllegalArgumentException("이메일이 이미 존재합니다.");
        }

        User newUser = new User(
                userSaveRequestDto.getUsername(),
                userSaveRequestDto.getEmail()
        );
        User savedUser = userRepository.save(newUser);

        return new UserSaveResponseDto(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail()
        );
    }

    public List<UserSimpleResponseDto> getUsers() {
        List<User> userList = userRepository.findAll();

        List<UserSimpleResponseDto> dtoList = new ArrayList<>();
        for (User user : userList) {
            dtoList.add(new UserSimpleResponseDto(user.getId(), user.getUsername()));
        }
        return dtoList;
    }

    public UserDetailResponseDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NullPointerException("해당하는 유저가 없습니다."));

        return new UserDetailResponseDto(user.getId(), user.getUsername(), user.getEmail());
    }

    @Transactional
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new NullPointerException("해당하는 유저가 없습니다.");
        }
        userRepository.deleteById(userId);
    }
}
