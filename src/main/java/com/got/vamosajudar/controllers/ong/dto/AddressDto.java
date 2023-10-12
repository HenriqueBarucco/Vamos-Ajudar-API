package com.got.vamosajudar.controllers.ong.dto;

import com.got.vamosajudar.entities.dao.Address;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDto {
    @NotBlank(message = "O nome da rua não pode ser vazio")
    private String street;
    @NotBlank(message = "O número da rua não pode ser vazio")
    private String number;
    @NotBlank(message = "O nome da cidade não pode ser vazio")
    private String city;
    @NotBlank(message = "O nome do estado não pode ser vazio")
    private String state;
    @NotBlank(message = "O CEP não pode ser vazio")
    private String postalCode;
    @NotBlank(message = "O nome do país não pode ser vazio")
    private String country;

    public AddressDto(Address address) {
        this.street = address.street();
        this.number = address.number();
        this.city = address.city();
        this.state = address.state();
        this.postalCode = address.postalCode();
        this.country = address.country();
    }
}
