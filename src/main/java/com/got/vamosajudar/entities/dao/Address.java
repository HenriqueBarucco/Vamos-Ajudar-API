package com.got.vamosajudar.entities.dao;

import com.got.vamosajudar.controllers.ong.dto.AddressDto;

public record Address(
        String street,
        String number,
        String city,
        String state,
        String postalCode,
        String country
) {
    public Address(AddressDto address) {
        this(
                address.getStreet(),
                address.getNumber(),
                address.getCity(),
                address.getState(),
                address.getPostalCode(),
                address.getCountry()
        );
    }
}
