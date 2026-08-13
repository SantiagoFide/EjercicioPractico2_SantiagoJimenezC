package cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.service;

import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.domain.Usuario;
import java.util.List;

public interface UsuarioService {

    List<Usuario> listarUsuarios();

    Usuario buscarUsuario(Long id);

    void guardarUsuario(Usuario usuario);

    void eliminarUsuario(Long id);

    List<Usuario> buscarPorRol(String nombreRol);
}