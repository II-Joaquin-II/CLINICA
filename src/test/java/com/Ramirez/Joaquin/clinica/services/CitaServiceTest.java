package com.Ramirez.Joaquin.clinica.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.Ramirez.Joaquin.clinica.repositories.CitaRepository;
import com.Ramirez.Joaquin.clinica.repositories.MedicoRepository;
import com.Ramirez.Joaquin.clinica.repositories.PacienteRepository;
import com.Ramirez.Joaquin.clinica.dtos.CitaDTO;
import com.Ramirez.Joaquin.clinica.enums.EstadoCita;
import com.Ramirez.Joaquin.clinica.models.Cita;
import com.Ramirez.Joaquin.clinica.models.Medico;
import com.Ramirez.Joaquin.clinica.models.Paciente;

@ExtendWith(MockitoExtension.class)
public class CitaServiceTest {

    // Simulacion de los repositorios para no tocar los datos reales
    @Mock
    private CitaRepository citaRepository;

    @Mock
    private PacienteRepository pacienteRepository;

    @Mock
    private MedicoRepository medicoRepository;

    // Injectar los repositorios simulados dentro de un servicio real
    @InjectMocks
    private CitaService citaService;

    @Test
    public void agendarCita_DebeLanzaError_CuandoElHorarioEstaOcupado() {
        // PREPARACION
        CitaDTO citaDTO = new CitaDTO();
        citaDTO.setPacienteId(1L);
        citaDTO.setMedicoId(1L);
        citaDTO.setFechaHora(LocalDateTime.of(2026, 8, 15, 10, 30));

        Mockito.when(pacienteRepository.findById(1L)).thenReturn(Optional.of(new Paciente()));
        Mockito.when(medicoRepository.findById(1L)).thenReturn(Optional.of(new Medico()));

        Mockito.when(citaRepository.existsByMedicoIdAndFechaHoraAndEstadoNot(1L, citaDTO.getFechaHora(),
                EstadoCita.CANCELADA)).thenReturn(true);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            citaService.agendarCita(citaDTO);
        });

        assertEquals("El médico ya tiene una cita en esa fecha y hora", exception.getMessage());
    }

    @Test
    public void agendarCita_DebeGuardarCita_CuandoElHorarioEstaLibre() {
        // ARRANQUE
        CitaDTO citaDTO = new CitaDTO();
        citaDTO.setPacienteId(1L);
        citaDTO.setMedicoId(1L);
        citaDTO.setFechaHora(LocalDateTime.of(2026, 8, 15, 10, 30));
        citaDTO.setMotivo("Dolor de cabeza");

        Paciente paciente = new Paciente();
        paciente.setId(1L);

        Medico medico = new Medico();
        medico.setId(1L);

        Cita citaGuardada = new Cita();
        citaGuardada.setId(100L); 
        citaGuardada.setEstado(EstadoCita.PENDIENTE);

        // Simulamos que el paciente y el médico existen
        Mockito.when(pacienteRepository.findById(1L)).thenReturn(Optional.of(paciente));
        Mockito.when(medicoRepository.findById(1L)).thenReturn(Optional.of(medico));

        // Simulamos que el horario está libre
        Mockito.when(citaRepository.existsByMedicoIdAndFechaHoraAndEstadoNot(
                1L, citaDTO.getFechaHora(), EstadoCita.CANCELADA)).thenReturn(false);

        Mockito.when(citaRepository.save(Mockito.any(Cita.class))).thenReturn(citaGuardada);

        // ACCION
        Cita resultado = citaService.agendarCita(citaDTO);

        // VERIFICACIÓN
        assertNotNull(resultado);
        assertEquals(100L, resultado.getId());
        assertEquals(EstadoCita.PENDIENTE, resultado.getEstado());
    }

}
