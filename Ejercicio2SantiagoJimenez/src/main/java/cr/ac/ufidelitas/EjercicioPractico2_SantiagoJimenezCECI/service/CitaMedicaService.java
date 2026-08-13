package cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.service;

import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.domain.CitaMedica;
import java.time.LocalDate;
import java.util.List;

public interface CitaMedicaService {

    List<CitaMedica> listarCitas();

    CitaMedica buscarCita(Long id);

    void guardarCita(CitaMedica cita);

    void eliminarCita(Long id);

    List<CitaMedica> buscarPorEstado(boolean activa);

    List<CitaMedica> buscarPorFechas(
            LocalDate fechaInicial,
            LocalDate fechaFinal
    );

    List<CitaMedica> buscarPorEspecialidad(String especialidad);

    long contarPorEstado(boolean activa);
}