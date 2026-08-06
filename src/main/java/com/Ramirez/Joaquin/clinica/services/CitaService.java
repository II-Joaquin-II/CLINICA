package com.Ramirez.Joaquin.clinica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Ramirez.Joaquin.clinica.dtos.CitaDTO;
import com.Ramirez.Joaquin.clinica.models.Cita;
import com.Ramirez.Joaquin.clinica.models.Medico;
import com.Ramirez.Joaquin.clinica.models.Paciente;
import com.Ramirez.Joaquin.clinica.repositories.CitaRepository;
import com.Ramirez.Joaquin.clinica.repositories.MedicoRepository;
import com.Ramirez.Joaquin.clinica.repositories.PacienteRepository;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public Cita agendarCita(CitaDTO citaDTO) {
        //1. Buscamos al paciente y al médico en la base de datos usando los IDs del DTO
        //En un proyecto real, aquí ser maneja el error si no existen, por ahora usare un orElseThrow
        Paciente paciente = pacienteRepository.findById(citaDTO.getPacienteId()).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        Medico medico = medicoRepository.findById(citaDTO.getMedicoId()).orElseThrow(() -> new RuntimeException("Médico no encontrado"));

        //2. Creamos la Entidad Cita real
        Cita nuevaCita = new Cita();
        nuevaCita.setFechaHora(citaDTO.getFechaHora());
        nuevaCita.setMotivo(citaDTO.getMotivo());
        nuevaCita.setPaciente(paciente);
        nuevaCita.setMedico(medico);

        //3. Guardamos en la base de datos
        return citaRepository.save(nuevaCita); 
    }

}
