package cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.serviceimpl;

import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.domain.CitaMedica;
import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.repository.CitaMedicaRepository;
import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.service.CitaMedicaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CitaMedicaServiceImpl implements CitaMedicaService {

    private final CitaMedicaRepository citaRepository;

    public CitaMedicaServiceImpl(CitaMedicaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public List<CitaMedica> listarCitas() {
        return citaRepository.findAll();
    }

    @Override
    public CitaMedica buscarCita(Long id) {
        return citaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarCita(CitaMedica cita) {
        citaRepository.save(cita);
    }

    @Override
    public void eliminarCita(Long id) {
        citaRepository.deleteById(id);
    }

    @Override
    public List<CitaMedica> buscarPorEstado(boolean activa) {
        return citaRepository.findByActiva(activa);
    }

    @Override
    public List<CitaMedica> buscarPorFechas(
            LocalDate fechaInicial,
            LocalDate fechaFinal) {

        return citaRepository.findByFechaBetween(
                fechaInicial,
                fechaFinal
        );
    }

    @Override
    public List<CitaMedica> buscarPorEspecialidad(String especialidad) {
        return citaRepository
                .findByEspecialidadContainingIgnoreCase(especialidad);
    }

    @Override
    public long contarPorEstado(boolean activa) {
        return citaRepository.countByActiva(activa);
    }
}