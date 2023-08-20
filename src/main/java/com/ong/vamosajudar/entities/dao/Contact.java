package com.ong.vamosajudar.entities.dao;

import com.ong.vamosajudar.controllers.ong.dto.ContactDto;

public record Contact(
        String email,
        String phone,
        String website
) {
    public Contact(ContactDto contact) {
        this(
                contact.getEmail(),
                contact.getPhone(),
                contact.getWebsite()
        );
    }
}
