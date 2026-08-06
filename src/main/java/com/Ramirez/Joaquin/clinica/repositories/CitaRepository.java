package com.Ramirez.Joaquin.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Ramirez.Joaquin.clinica.models.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    

}
