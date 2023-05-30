package com.web.socket.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    private String firstName;
    private String lastName;
    private Boolean status;
}
