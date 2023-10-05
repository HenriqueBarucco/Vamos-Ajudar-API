package com.got.vamosajudar.controllers.ong.dto;

import com.got.vamosajudar.entities.dao.Address;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
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
}
