package cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.controllers;

import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.domain.CitaMedica;
import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.service.CitaMedicaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/citas")
public class CitaMedicaController {

    private final CitaMedicaService citaService;

    public CitaMedicaController(CitaMedicaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("citas", citaService.listarCitas());
        return "citas/listado";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("cita", new CitaMedica());
        return "citas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(CitaMedica cita) {
        citaService.guardarCita(cita);
        return "redirect:/citas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("cita", citaService.buscarCita(id));
        return "citas/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        citaService.eliminarCita(id);
        return "redirect:/citas";
    }
}