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

}
