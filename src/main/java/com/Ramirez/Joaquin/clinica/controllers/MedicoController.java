package com.Ramirez.Joaquin.clinica.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Ramirez.Joaquin.clinica.models.Medico;
import com.Ramirez.Joaquin.clinica.services.MedicoService;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    //endpoint para crear un medico
    @PostMapping
    public ResponseEntity<Medico> crearMedico(@RequestBody Medico medico) {
        Medico medicoGuardado = medicoService.guardarMedico(medico);
        return new ResponseEntity<>(medicoGuardado, HttpStatus.CREATED);
    }

    //endpoint para listar todos los medicos
    @GetMapping
    public ResponseEntity<List<Medico>> listarMedicos() {
        List<Medico> medicos = medicoService.listarMedicos();
        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }

    //endpoint para buscar un medico por id
    @GetMapping("/{id}")
    public ResponseEntity<Medico> obtenerMedicoPorId(@PathVariable Long id) {
        Medico medico = medicoService.obtenerMedicoPorId(id);
        return new ResponseEntity<>(medico, HttpStatus.OK);
    }

    //endpoint para buscar un medico por matricula
    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<Medico> obtenerMedicoPorMatricula(@PathVariable String matricula) {
        Medico medico = medicoService.obtenerMedicoPorMatricula(matricula);
        return new ResponseEntity<>(medico, HttpStatus.OK);
    }

    //endpoint para actualizar los datos de los medicos
    @PutMapping("/{id}")
    public ResponseEntity<Medico> actualizarMedico(@PathVariable Long id, @RequestBody Medico medico) {
        Medico medicoActualizado = medicoService.actualizarMedico(id, medico);
        return new ResponseEntity<>(medicoActualizado, HttpStatus.OK);
    }

}
