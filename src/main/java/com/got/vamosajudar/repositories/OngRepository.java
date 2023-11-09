package com.got.vamosajudar.repositories;

import com.got.vamosajudar.entities.Ong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OngRepository extends JpaRepository<Ong, String> {

    Ong findByNameIgnoreCaseAndActiveTrue(String name);

    Boolean existsByNameAndActiveTrue(String name);

    Page<List<Ong>> findByActiveTrue(Pageable pageable);

    @Query(value = "SELECT o FROM Ong o ORDER BY FUNCTION('RAND') FETCH FIRST 1 ROW ONLY")
    Ong findRandom();
}
