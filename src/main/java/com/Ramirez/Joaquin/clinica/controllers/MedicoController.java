package com.Ramirez.Joaquin.clinica.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public ResponseEntity<Medico> crearMedico(@RequestBody Medico medico) {
        Medico medicoGuardado = medicoService.guardarMedico(medico);
        return new ResponseEntity<>(medicoGuardado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Medico>> listarMedicos() {
        List<Medico> medicos = medicoService.listarMedicos();
        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }

}
