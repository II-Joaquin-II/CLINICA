package com.Ramirez.Joaquin.clinica.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Ramirez.Joaquin.clinica.models.Medico;
import com.Ramirez.Joaquin.clinica.repositories.MedicoRepository;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    //Metodo para guardar un medico 
    public Medico guardarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    //Metodo para listar todos los medicos
    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    //Metodo para buscar un medico por id
    public Medico obtenerMedicoPorId(Long id) {
        return medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Médico no encontrado con id: " + id));
    }

    //Metodo para buscar un medico por matricula
    public Medico obtenerMedicoPorMatricula(String matricula) {
        return medicoRepository.findByMatricula(matricula).orElseThrow(() -> new RuntimeException("Matrícula del médico no encontrada: " + matricula));
    }

    //Metodo para actualizar los datos de los medicos 
    public Medico actualizarMedico(Long id, Medico datosnuevos) {
        Medico medico = medicoRepository.findAllById(id).orElseThrow(() -> new RuntimeException("Medico no encontrado"));
        
        medico.setNombre(datosnuevos.getNombre());
        medico.setApellido(datosnuevos.getApellido());
        medico.setEspecialidad(datosnuevos.getEspecialidad());
        medico.setMatricula(datosnuevos.getMatricula());

        return medicoRepository.save(medico);
    }

}
