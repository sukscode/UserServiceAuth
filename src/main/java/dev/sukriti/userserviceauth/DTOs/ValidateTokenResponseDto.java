package dev.sukriti.userserviceauth.DTOs;

import dev.sukriti.userserviceauth.Models.SessionStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateTokenResponseDto {
    private UserDto userDto;
    private SessionStatus sessionStatus;
}