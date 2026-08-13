package cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.repository;

import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.domain.CitaMedica;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaMedicaRepository extends JpaRepository<CitaMedica, Long> {

    List<CitaMedica> findByActiva(boolean activa);

    List<CitaMedica> findByFechaBetween(
            LocalDate fechaInicial,
            LocalDate fechaFinal
    );

    List<CitaMedica> findByEspecialidadContainingIgnoreCase(
            String especialidad
    );

    long countByActiva(boolean activa);
}