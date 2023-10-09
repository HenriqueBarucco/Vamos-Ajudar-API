package com.got.vamosajudar.controllers.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public record RegisterDTO(
        @NotBlank
        String login,
        @Email
        String email,
        @NotBlank
        String password,
        @NotBlank
        String name,

        String image
) {
        public String encryptedPassword() {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                return encoder.encode(this.password);
        }
}
