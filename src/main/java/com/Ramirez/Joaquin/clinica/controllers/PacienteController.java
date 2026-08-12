package com.Ramirez.Joaquin.clinica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Ramirez.Joaquin.clinica.models.Paciente;
import com.Ramirez.Joaquin.clinica.services.PacienteService;
import jakarta.websocket.server.PathParam;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    //Mover las inyecciones del repositorio a la capa de servicio para mantener la lógica de negocio separada del controlador.
    @Autowired
    private PacienteService pacienteService;

    /* 
    Ejemplo de cómo se vería si se inyectara el repositorio directamente en el controlador, lo cual no es recomendable.
    @Autowired
    private PacienteRepository pacienteRepository;
    */

    //endpoint para guardar pacientes
    @PostMapping
    public ResponseEntity<Paciente> crearPaciente(@RequestBody Paciente paciente) {
        Paciente pacienteGuardado = pacienteService.pacienteGuardado(paciente);
        return new ResponseEntity<>(pacienteGuardado, HttpStatus.CREATED);
    }

    //endpoint para listar pacientes
    /* 
    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes() {
        List<Paciente> pacientes = pacienteService.listarPacientes();
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }
    */

    //endpoint para listar pacientes con paginacion
    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes(

        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size

    ) {
        Page<Paciente> pacientes = pacienteService.obtenerTodosLosPacientes(page, size);
        return new ResponseEntity<>(pacientes.getContent(), HttpStatus.OK);
    }

    //endpoint para buscar pacientes por id
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtenerPacientePorId(@PathVariable Long id) {
        Paciente paciente = pacienteService.obtenerPacientePorId(id);
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

    //endpoint para buscar pacientes por DNI
    @GetMapping("/dni/{dni}")
    public ResponseEntity<Paciente> obtenerPacientePorDni(@PathVariable String dni) {
        Paciente paciente = pacienteService.obtenerPacientePorDni(dni);
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

}
