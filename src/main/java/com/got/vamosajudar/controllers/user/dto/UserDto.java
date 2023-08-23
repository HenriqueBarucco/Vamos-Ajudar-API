package com.got.vamosajudar.controllers.user.dto;

import com.got.vamosajudar.entities.User;
import com.got.vamosajudar.entities.dao.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private String name;
    private String email;
    private String login;
    private UserRole userRole;

    public UserDto(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.login = user.getLogin();
        this.userRole = user.getUserRole();
    }
}
