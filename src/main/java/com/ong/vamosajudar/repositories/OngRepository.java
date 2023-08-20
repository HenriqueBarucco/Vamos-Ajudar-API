package com.ong.vamosajudar.repositories;

import com.ong.vamosajudar.entities.Ong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OngRepository  extends JpaRepository<Ong, String> {
}
