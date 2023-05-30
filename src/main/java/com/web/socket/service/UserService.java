package com.web.socket.service;

import com.web.socket.dto.UserDto;
import com.web.socket.dto.UserResponseDto;
import com.web.socket.dto.UserUpdateDto;

public interface UserService {

    UserResponseDto updateUser(Long userId, UserUpdateDto userUpdateDto);

    UserResponseDto createUser(UserDto userDto);

    UserResponseDto getUser(Long userId);
}
