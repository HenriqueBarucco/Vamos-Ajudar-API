package com.got.vamosajudar.entities.dao;

import com.got.vamosajudar.controllers.ong.dto.ContactDto;

import java.io.Serializable;

public record Contact(
        String email,
        String phone,
        String website
) implements Serializable {
    public Contact(ContactDto contact) {
        this(
                contact.getEmail(),
                contact.getPhone(),
                contact.getWebsite()
        );
    }
}
