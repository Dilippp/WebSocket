package com.web.socket.controller;

import com.web.socket.dto.UserDto;
import com.web.socket.dto.UserResponseDto;
import com.web.socket.dto.UserUpdateDto;
import com.web.socket.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record UserRestController(UserService userService) {

    @PostMapping(value = "/users")
    public UserResponseDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping(value = "/users/{userId}")
    public UserResponseDto updateUser(
            @PathVariable (name = "userId") Long userId,
            @RequestBody UserUpdateDto userUpdateDto) {
        return userService.updateUser(userId, userUpdateDto);
    }

    @GetMapping(value = "/users/{userId}")
    public UserResponseDto getUser(@PathVariable(name = "userId") Long userId) {
        return userService.getUser(userId);
    }
}
