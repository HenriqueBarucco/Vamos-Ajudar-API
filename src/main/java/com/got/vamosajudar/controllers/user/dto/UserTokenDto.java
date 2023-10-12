package com.got.vamosajudar.controllers.user.dto;

import com.got.vamosajudar.controllers.ong.dto.OngDto;
import com.got.vamosajudar.controllers.ong.dto.RequestOngDto;
import com.got.vamosajudar.entities.User;
import lombok.Data;

@Data
public class UserTokenDto extends UserDto {
    private String token;
    private OngDto ong;

    public UserTokenDto(User user) {
        super(user);
    }

    public UserTokenDto(User user, String token) {
        super(user);
        this.token = token;
        this.ong = user.getOng() != null ? new OngDto(user.getOng()) : null;
    }
}