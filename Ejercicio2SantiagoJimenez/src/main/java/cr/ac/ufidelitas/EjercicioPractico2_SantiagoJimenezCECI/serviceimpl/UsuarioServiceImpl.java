package cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.serviceimpl;

import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.domain.Usuario;
import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.repository.UsuarioRepository;
import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.service.UsuarioService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> buscarPorRol(String nombreRol) {
        return usuarioRepository.findByRolNombre(nombreRol);
    }
}