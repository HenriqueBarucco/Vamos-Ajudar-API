package com.ong.vamosajudar.controllers.ong.dto;

import com.ong.vamosajudar.entities.dao.Address;
import lombok.Data;

@Data
public class AddressDto {
    private String street;
    private String number;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
