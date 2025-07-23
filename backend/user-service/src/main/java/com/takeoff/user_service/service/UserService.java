package com.takeoff.user_service.service;

import com.takeoff.user_service.dto.UserRequestDto;
import com.takeoff.user_service.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto requestDto);
    UserResponseDto getUserByEmail(String email);
    List<UserResponseDto> getAllUsers();
    boolean userExists(String email);
}
