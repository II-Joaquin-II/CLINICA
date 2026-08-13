package com.Ramirez.Joaquin.clinica.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Ramirez.Joaquin.clinica.models.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    //Spring creara automáticamente la consulta para buscar un médico por su matrícula
    Optional<Medico> findByMatricula(String matricula);

    Optional<Medico> findAllById(Long id);

}
