package com.got.vamosajudar.controllers.ong.dto;

import com.got.vamosajudar.entities.dao.Contact;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactDto {
    @NotBlank(message = "O email da ONG não pode ser vazio")
    private String email;
    @NotBlank(message = "O telefone da ONG não pode ser vazio")
    private String phone;
    private String website;

    public ContactDto(Contact contact) {
        this.email = contact.email();
        this.phone = contact.phone();
        this.website = contact.website();
    }
}
