package com.ong.vamosajudar.controllers.ong.dto;

import lombok.Data;

@Data
public class OngDto {
    private String name;
    private String description;
    private String goal;
    private AddressDto address;
    private ContactDto contact;
}
