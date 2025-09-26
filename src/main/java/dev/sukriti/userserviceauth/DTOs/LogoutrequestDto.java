package dev.sukriti.userserviceauth.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogoutrequestDto {
    private String token;
    private Long userId;
}
