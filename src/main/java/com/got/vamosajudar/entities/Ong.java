package com.got.vamosajudar.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.got.vamosajudar.controllers.ong.dto.OngDto;
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

    private boolean verified;

    private boolean active;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:MM:ss")
    private LocalDateTime deletedAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:MM:ss")
    private LocalDateTime updatedAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:MM:ss")
    private LocalDateTime createdAt;

    public Ong(OngDto ongDto) {
        this.name = ongDto.getName();
        this.description = ongDto.getDescription();
        this.goal = ongDto.getGoal();
        this.address = new Address(ongDto.getAddress());
        this.contact = new Contact(ongDto.getContact());
        this.verified = false;
        this.active = true;
        this.createdAt = LocalDateTime.now();
    }
}
