package com.got.vamosajudar.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.got.vamosajudar.controllers.ong.dto.RequestOngDto;
import com.got.vamosajudar.entities.dao.Address;
import com.got.vamosajudar.entities.dao.Contact;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ongs_tbl")
@Data
@NoArgsConstructor
public class Ong {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String description;

    private String goal;

    @Embedded
    private Address address;

    @Embedded
    private Contact contact;

    private String image;

    private String chavePix;

    private boolean verified;

    private boolean active;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:MM:ss")
    private LocalDateTime deletedAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:MM:ss")
    private LocalDateTime updatedAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:MM:ss")
    private LocalDateTime createdAt;

    public Ong(RequestOngDto requestOngDto) {
        this.name = requestOngDto.getName();
        this.description = requestOngDto.getDescription();
        this.goal = requestOngDto.getGoal();
        this.address = new Address(requestOngDto.getAddress());
        this.contact = new Contact(requestOngDto.getContact());
        this.verified = false;
        this.active = true;
        this.createdAt = LocalDateTime.now();
        this.chavePix = requestOngDto.getPix();
    }
}
