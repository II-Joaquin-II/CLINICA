package com.Ramirez.Joaquin.clinica.controllers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Ramirez.Joaquin.clinica.dtos.CitaDTO;
import com.Ramirez.Joaquin.clinica.dtos.CitaResponseDTO;
import com.Ramirez.Joaquin.clinica.models.Cita;
import com.Ramirez.Joaquin.clinica.services.CitaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    //endpoint para agendar citas
    @PostMapping
    public ResponseEntity<Cita> agendarCita(@Valid @RequestBody CitaDTO citaDTO) {
        Cita citaGuardada = citaService.agendarCita(citaDTO);
        return new ResponseEntity<>(citaGuardada, HttpStatus.CREATED);
    }

    //endpoint para listar citas
    @GetMapping
    public ResponseEntity<List<Cita>> listarCitas() {
        List<Cita> citas = citaService.listarCitas();
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }
    

    //endopint para cancelar citas
    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Cita> cancelarCitar(@PathVariable Long id) {
        Cita citaCancelada = citaService.cancelarCita(id);
        return new ResponseEntity<>(citaCancelada, HttpStatus.OK);
    }

    //endpoint para ver el historial de un paciente
    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<Cita>> listarCitasPorPaciente(@PathVariable Long pacienteId) {
        List<Cita> citas = citaService.obtenerCitasPorPaciente(pacienteId);
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    //endpoint para ver la agenda de un medico
    @GetMapping("/medico/{medicoId}")
    public ResponseEntity<List<CitaResponseDTO>> listarCitasPorMedico(@PathVariable Long medicoId) {
        List<Cita> citas = citaService.obtenerCitasPorMedico(medicoId);

        List<CitaResponseDTO> citasDTO = citas.stream()
                .map(CitaResponseDTO::new)
                .collect(Collectors.toList());

        return new ResponseEntity<>(citasDTO, HttpStatus.OK);
    }


    /* 
    @GetMapping("/medico/{medicoId}")
    public ResponseEntity<List<Cita>> listarCitasPorMedico(@PathVariable Long medicoId) {
        List<Cita> citas = citaService.obtenerCitasPorMedico(medicoId);
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }
    */

}
