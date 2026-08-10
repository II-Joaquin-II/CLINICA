package com.Ramirez.Joaquin.clinica.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Ramirez.Joaquin.clinica.models.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    
    //Spring --> "SELECT count(*) FROM citas WHERE medico_id = ? AND fecha_hora = ?"
    boolean existsByMedicoIdAndFechaHora(Long medicoId, java.time.LocalDateTime fechaHora, com.Ramirez.Joaquin.clinica.enums.EstadoCita estado);

}
