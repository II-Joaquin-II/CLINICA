package com.Ramirez.Joaquin.clinica.dtos;

import java.time.LocalDateTime;

public class CitaDTO {

    private LocalDateTime fechaHora;
    private String motivo;
    
    //IDs de los objetos relacionados
    private Long pacienteId;
    private Long medicoId;

    public CitaDTO() {
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Long getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }

}
