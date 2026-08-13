package com.Ramirez.Joaquin.clinica.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.Ramirez.Joaquin.clinica.models.Paciente;
import com.Ramirez.Joaquin.clinica.repositories.PacienteRepository;

@Service
public class PacienteService {

    //Mover la inyeciones del repositorio a la capa de servicio para mantener la lógica de negocio separada del controlador.
    @Autowired
    private PacienteRepository pacienteRepository;


    //Metodo de paginacion 
    public Page<Paciente> obtenerTodosLosPacientes(int page, int size) {
        //Crear un objeto Pageable con el número de página y el tamaño de página
        Pageable paginacion = PageRequest.of(page, size);
        //El repositorio devuelve un objeto Page en lugar de un List
        return pacienteRepository.findAll(paginacion);
    }

    //Metodo para guardar pacientes, que se puede llamar desde el controlador.
    public Paciente pacienteGuardado(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    //Metodo buscar pacientes por id
    public Paciente obtenerPacientePorId(Long id) {
        return pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente no encontrado con id: " + id));
    }
    
    //Metodo para buscar pacientes por DNI
    public Paciente obtenerPacientePorDni(String dni) {
        return pacienteRepository.findByDni(dni).orElseThrow(() -> new RuntimeException("DNI del paciente no encontrado: " + dni));
    }

    //Metodo para actualizar pacientes
    public Paciente actualizarPaciente(Long id, Paciente datosnuevos) {
        Paciente paciente = pacienteRepository.findAllById(id).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        paciente.setNombre(datosnuevos.getNombre());
        paciente.setApellido(datosnuevos.getApellido());
        paciente.setTelefono(datosnuevos.getTelefono());
        paciente.setEmail(datosnuevos.getEmail());

        return pacienteRepository.save(paciente);

    }

}
