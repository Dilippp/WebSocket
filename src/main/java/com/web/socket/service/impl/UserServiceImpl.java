package com.web.socket.service.impl;

import com.web.socket.dto.UserDto;
import com.web.socket.dto.UserResponseDto;
import com.web.socket.dto.UserUpdateDto;
import com.web.socket.model.User;
import com.web.socket.repository.UserServiceRepository;
import com.web.socket.service.UserService;
import org.springframework.stereotype.Service;

@Service
public record UserServiceImpl(
        UserServiceRepository userServiceRepository) implements UserService {

    @Override
    public UserResponseDto createUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        User savedUser = userServiceRepository.save(user);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setFirstName(savedUser.getFirstName());
        userResponseDto.setLastName(savedUser.getLastName());
        userResponseDto.setStatus(savedUser.getStatus());
        return userResponseDto;
    }

    @Override
    public UserResponseDto updateUser(Long userId, UserUpdateDto userUpdateDto) {
        User user = fetchUser(userId);
        user.setStatus(userUpdateDto.getStatus());
        User updatedUser = userServiceRepository.save(user);
        UserResponseDto userResponseDto= new UserResponseDto();
        userResponseDto.setId(updatedUser.getId());
        userResponseDto.setFirstName(updatedUser.getFirstName());
        userResponseDto.setLastName(updatedUser.getLastName());
        userResponseDto.setStatus(updatedUser.getStatus());
        return userResponseDto;
    }

    @Override
    public UserResponseDto getUser(Long userId) {
        User user = fetchUser(userId);
        UserResponseDto userResponseDto= new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setStatus(user.getStatus());
        return userResponseDto;
    }

    private User fetchUser(Long userId) {
        return userServiceRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("User not found with given id: " + userId));
    }
}
