package com.got.vamosajudar.controllers.ong.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContactDto {
    @NotBlank(message = "O email da ONG não pode ser vazio")
    private String email;
    @NotBlank(message = "O telefone da ONG não pode ser vazio")
    private String phone;
    private String website;
}
