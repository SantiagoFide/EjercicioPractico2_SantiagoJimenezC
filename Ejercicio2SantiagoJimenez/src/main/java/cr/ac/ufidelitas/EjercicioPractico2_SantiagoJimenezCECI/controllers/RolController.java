package cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.controllers;

import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.domain.Rol;
import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.service.RolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("roles", rolService.listarRoles());
        return "roles/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("rol", new Rol());
        return "roles/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(Rol rol) {
        rolService.guardarRol(rol);
        return "redirect:/roles";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("rol", rolService.buscarRol(id));
        return "roles/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        rolService.eliminarRol(id);
        return "redirect:/roles";
    }
}