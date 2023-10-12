package com.got.vamosajudar.controllers.user.dto;

import com.got.vamosajudar.entities.User;
import com.got.vamosajudar.entities.dao.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private String name;
    private String email;
    private String login;
    private String image;
    private UserRole userRole;

    public UserDto(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.login = user.getLogin();
        this.image = user.getImage();
        this.userRole = user.getUserRole();
    }
}
