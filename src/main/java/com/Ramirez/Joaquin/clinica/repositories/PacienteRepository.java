package com.Ramirez.Joaquin.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Ramirez.Joaquin.clinica.models.Paciente;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    //Spring creara automáticamente la consulta para buscar un paciente por su DNI
    Optional<Paciente> findByDni(String dni);

    Optional<Paciente> findAllById(Long id);
    
}

