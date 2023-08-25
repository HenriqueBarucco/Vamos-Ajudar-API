package com.got.vamosajudar.repositories;

import com.got.vamosajudar.entities.Ong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OngRepository  extends JpaRepository<Ong, String> {

    Ong findByNameIgnoreCaseAndActiveTrue(String name);

    Boolean existsByNameAndActiveTrue(String name);

    List<Ong> findByActiveTrue();
}
