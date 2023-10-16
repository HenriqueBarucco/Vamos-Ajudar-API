package com.got.vamosajudar.controllers.user.dto;

import com.got.vamosajudar.entities.User;
import lombok.Data;

@Data
public class UserTokenDto extends UserOngDto {
    private String token;

    public UserTokenDto(User user, String token) {
        super(user);
        this.token = token;
    }
}