package com.got.vamosajudar.services;

import com.got.vamosajudar.controllers.ong.dto.OngDto;
import com.got.vamosajudar.entities.Ong;
import com.got.vamosajudar.entities.User;
import com.got.vamosajudar.repositories.OngRepository;
import com.got.vamosajudar.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OngService {

    @Autowired
    private OngRepository ongRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Ong> findAll() {
        return ongRepository.findByActiveTrue();
    }

    public Ong create(OngDto ongDto) {
        if (ongRepository.existsByNameAndActiveTrue(ongDto.getName())) {
            // TODO Exceção personalizada
            throw new RuntimeException("Ong já existente.");
        }

        User user = userRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get();

        if (user.getOng() != null) {
            // TODO Exceção personalizada
            throw new RuntimeException("Usuário já possui uma ONG.");
        }

        Ong ong = ongRepository.save(new Ong(ongDto));

        user.setOng(ong);
        userRepository.save(user);

        return ong;
    }

    public Ong findByName(String name) {
        // TODO ADICIONAR TRATATIVA
        return ongRepository.findByNameIgnoreCaseAndActiveTrue(name);
    }

    public void delete() {
        User user = userRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).get();

        if (user.getOng() == null) {
            // TODO ADICIONAR TRATATIVA
            throw new RuntimeException("Usuário não possui uma ONG.");
        }

        deleteUserOng(user);
    }

    private void deleteUserOng(User user) {
        Ong ong = user.getOng();

        ong.setActive(false);
        ong.setDeletedAt(LocalDateTime.now());

        user.setOng(null);

        userRepository.save(user);
        ongRepository.save(ong);
    }
}
