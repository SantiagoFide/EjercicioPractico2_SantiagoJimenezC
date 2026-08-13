package cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.controllers;

import java.util.Collection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/redireccion")
    public String redireccion(Authentication authentication) {

        Collection<? extends GrantedAuthority> permisos
                = authentication.getAuthorities();

        for (GrantedAuthority permiso : permisos) {

            if (permiso.getAuthority().equals("ROLE_ADMIN")) {
                return "redirect:/";
            }

            if (permiso.getAuthority().equals("ROLE_MEDICO")) {
                return "redirect:/citas";
            }

            if (permiso.getAuthority().equals("ROLE_PACIENTE")) {
                return "redirect:/citas";
            }
        }

        return "redirect:/login";
    }
}