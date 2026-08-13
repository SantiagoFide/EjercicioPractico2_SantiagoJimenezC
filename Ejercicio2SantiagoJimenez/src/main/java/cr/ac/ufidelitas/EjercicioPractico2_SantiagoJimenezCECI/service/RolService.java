package cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.service;

import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.domain.Rol;
import java.util.List;

public interface RolService {

    List<Rol> listarRoles();

    Rol buscarRol(Long id);

    void guardarRol(Rol rol);

    void eliminarRol(Long id);
}