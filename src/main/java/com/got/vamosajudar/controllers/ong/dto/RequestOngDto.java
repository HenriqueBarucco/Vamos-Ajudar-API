package com.got.vamosajudar.controllers.ong.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestOngDto {
    @NotBlank(message = "O nome da ONG não pode ser vazio")
    private String name;
    @NotBlank(message = "A descrição da ONG não pode ser vazia")
    private String description;
    @NotBlank(message = "O objetivo da ONG não pode ser vazio")
    private String goal;
    private AddressDto address;
    private ContactDto contact;
    @NotBlank(message = "A imagem da ONG não pode ser vazia")
    private String image;
    @NotBlank(message = "A chave PIX da ONG não pode ser vazia")
    private String pix;
}
