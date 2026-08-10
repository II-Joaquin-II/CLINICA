package com.Ramirez.Joaquin.clinica.dtos;

import java.time.LocalDateTime;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CitaDTO {

    @NotNull(message = "La fecha y hora son obligatorias")
    @Future(message = "La cita debe programarse para una fecha futura")
    private LocalDateTime fechaHora;

    @NotBlank(message = "El motivo de la cita no puede estar vacío")
    private String motivo;
    
    //IDs de los objetos relacionados
    @NotNull(message = "El ID del paciente es obligatorio")
    private Long pacienteId;

    @NotNull(message = "El ID del médico es obligatorio")
    private Long medicoId;

    @NotNull(message = "El estado de la cita es obligatorio")
    private com.Ramirez.Joaquin.clinica.enums.EstadoCita estado;

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

    public com.Ramirez.Joaquin.clinica.enums.EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(com.Ramirez.Joaquin.clinica.enums.EstadoCita estado) {
        this.estado = estado;
    }

}
