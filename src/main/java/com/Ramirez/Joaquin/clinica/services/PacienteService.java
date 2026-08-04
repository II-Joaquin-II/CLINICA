package com.Ramirez.Joaquin.clinica.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Ramirez.Joaquin.clinica.models.Paciente;
import com.Ramirez.Joaquin.clinica.repositories.PacienteRepository;

@Service
public class PacienteService {

    //Mover la inyeciones del repositorio a la capa de servicio para mantener la lógica de negocio separada del controlador.
    @Autowired
    private PacienteRepository pacienteRepository;

    //Metodo para guardar pacientes, que se puede llamar desde el controlador.
    public Paciente pacienteGuardado(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    //Metodo para listar pacientes, que se puede llamar desde el controlador.
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

}
