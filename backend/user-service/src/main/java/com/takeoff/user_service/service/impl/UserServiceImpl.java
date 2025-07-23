package com.takeoff.user_service.service.impl;

import com.takeoff.user_service.dto.UserRequestDto;
import com.takeoff.user_service.dto.UserResponseDto;
import com.takeoff.user_service.entity.User;
import com.takeoff.user_service.exception.UserNotFoundException;
import com.takeoff.user_service.repository.UserRepository;
import com.takeoff.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto requestDto) {
        User user = new User();
        user.setName(requestDto.getName());
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword()); // Normally, you'd hash the password

        User saved = userRepository.save(user);

        return mapToResponseDto(saved);
    }

    @Override
    public UserResponseDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
        return mapToResponseDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean userExists(String email) {
        return userRepository.existsByEmail(email);
    }

    private UserResponseDto mapToResponseDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
