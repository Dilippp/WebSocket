package com.web.socket.controller;

import com.web.socket.dto.UserResponseDto;
import com.web.socket.dto.UserUpdateDto;
import com.web.socket.service.UserService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public record UserSocketController(UserService userService) {

    @MessageMapping("/user/{userId}")
    @SendTo("/topic/user/{userId}")
    public UserUpdateDto getUser(@DestinationVariable String userId) {
        UserResponseDto user = userService.getUser(Long.valueOf(userId));
        UserUpdateDto userUpdateDto = new UserUpdateDto();
        userUpdateDto.setStatus(user.getStatus());
        return userUpdateDto;
    }
}
