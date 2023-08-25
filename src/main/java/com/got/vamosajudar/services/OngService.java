package com.got.vamosajudar.services;

import com.got.vamosajudar.controllers.ong.dto.OngDto;
import com.got.vamosajudar.entities.Ong;
import com.got.vamosajudar.repositories.OngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OngService {

    @Autowired
    private OngRepository ongRepository;

    public List<Ong> findAll() {
        return ongRepository.findAll();
    }

    public Ong create(OngDto ongDto) {
        if (ongRepository.existsByName(ongDto.getName())) {
            throw new RuntimeException("Ong já existente.");
        }
        return ongRepository.save(new Ong(ongDto));
    }

    public Ong findByName(String name) {
        // TODO ADICIONAR TRATATIVA
        return ongRepository.findByNameIgnoreCase(name);
    }
}
