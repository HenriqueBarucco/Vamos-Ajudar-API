package com.got.vamosajudar.controllers.ong.dto;

import com.got.vamosajudar.entities.Ong;
import lombok.Data;

@Data
public class OngDto {
    private String id;

    private String name;

    private String description;

    private String goal;

    private AddressDto address;

    private ContactDto contact;

    private String image;

    private String chavePix;

    public OngDto(Ong ong) {
        this.id = ong.getId();
        this.name = ong.getName();
        this.description = ong.getDescription();
        this.goal = ong.getGoal();
        this.address = new AddressDto(ong.getAddress());
        this.contact = new ContactDto(ong.getContact());
        this.image = ong.getImage();
        this.chavePix = ong.getChavePix();
    }
}
