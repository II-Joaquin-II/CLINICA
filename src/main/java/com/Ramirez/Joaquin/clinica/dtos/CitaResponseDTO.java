package com.Ramirez.Joaquin.clinica.dtos;

import java.time.LocalDateTime;
import com.Ramirez.Joaquin.clinica.enums.EstadoCita;
import com.Ramirez.Joaquin.clinica.models.Cita;

public class CitaResponseDTO {
    private Long id;
    private LocalDateTime fechaHora;
    private String motivo;
    private EstadoCita estado;
    private String nombrePaciente;
    private String nombreMedico;

    public CitaResponseDTO() {
    }

    public CitaResponseDTO(Cita cita) {
        this.id = cita.getId();
        this.fechaHora = cita.getFechaHora();
        this.motivo = cita.getMotivo();
        this.estado = cita.getEstado();
        this.nombrePaciente = cita.getPaciente().getNombre() + " " + cita.getPaciente().getApellido();
        this.nombreMedico = "Dr. " + cita.getMedico().getNombre() + " " + cita.getMedico().getApellido();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

}
