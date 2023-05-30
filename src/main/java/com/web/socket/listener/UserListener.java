package com.web.socket.listener;

import com.web.socket.dto.UserUpdateDto;
import com.web.socket.model.User;
import jakarta.persistence.PostUpdate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public record UserListener(SimpMessagingTemplate simpMessagingTemplate) {

    @PostUpdate
    public void afterAnyUpdate(User user) {
        // call the websocket endpoint
        UserUpdateDto userUpdateDto = new UserUpdateDto();
        userUpdateDto.setStatus(user.getStatus());
        simpMessagingTemplate.convertAndSend("/topic/user/" + user.getId(), userUpdateDto);
    }
}
