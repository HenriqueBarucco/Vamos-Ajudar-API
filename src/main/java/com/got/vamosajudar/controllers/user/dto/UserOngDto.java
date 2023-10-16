package com.got.vamosajudar.controllers.user.dto;

import com.got.vamosajudar.controllers.ong.dto.OngDto;
import com.got.vamosajudar.entities.User;
import lombok.Data;

@Data
public class UserOngDto extends UserDto {
    private OngDto ong;

    public UserOngDto() {
    }

    public UserOngDto(User user) {
        super(user);
        this.ong = user.getOng() != null ? new OngDto(user.getOng()) : null;
    }
}
