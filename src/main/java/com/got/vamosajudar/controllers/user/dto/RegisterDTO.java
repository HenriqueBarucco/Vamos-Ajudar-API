package com.got.vamosajudar.controllers.user.dto;

import com.got.vamosajudar.entities.dao.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(

        @NotBlank
        String login,
        @Email
        String email
        ,
        @NotBlank
        String password,
        String name,
        UserRole role
) {
}
