package dev.sukriti.userserviceauth.DTOs;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class SetUserRolesRequestDto {
    private List<Long> roleIds;
}
