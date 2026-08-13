package cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.controllers;

import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.service.CitaMedicaService;
import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    private final CitaMedicaService citaService;

    public ConsultaController(CitaMedicaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public String mostrarConsultas(Model model) {
        model.addAttribute("cantidadActivas", citaService.contarPorEstado(true));
        return "consultas/index";
    }

    @GetMapping("/estado")
    public String buscarPorEstado(
            @RequestParam boolean activa,
            Model model) {

        model.addAttribute(
                "resultados",
                citaService.buscarPorEstado(activa)
        );

        model.addAttribute(
                "tipoConsulta",
                activa ? "Citas Activas" : "Citas Inactivas"
        );

        model.addAttribute(
                "cantidadActivas",
                citaService.contarPorEstado(true)
        );

        return "consultas/index";
    }

    @GetMapping("/especialidad")
    public String buscarPorEspecialidad(
            @RequestParam String especialidad,
            Model model) {

        model.addAttribute(
                "resultados",
                citaService.buscarPorEspecialidad(especialidad)
        );

        model.addAttribute(
                "tipoConsulta",
                "Especialidad: " + especialidad
        );

        model.addAttribute(
                "cantidadActivas",
                citaService.contarPorEstado(true)
        );

        return "consultas/index";
    }

    @GetMapping("/fechas")
    public String buscarPorFechas(
            @RequestParam LocalDate fechaInicial,
            @RequestParam LocalDate fechaFinal,
            Model model) {

        model.addAttribute(
                "resultados",
                citaService.buscarPorFechas(fechaInicial, fechaFinal)
        );

        model.addAttribute(
                "tipoConsulta",
                "Rango de Fechas"
        );

        model.addAttribute(
                "cantidadActivas",
                citaService.contarPorEstado(true)
        );

        return "consultas/index";
    }
}