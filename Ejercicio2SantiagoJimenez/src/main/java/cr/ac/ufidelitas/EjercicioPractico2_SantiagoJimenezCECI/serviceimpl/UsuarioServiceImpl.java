package cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.serviceimpl;

import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.domain.Usuario;
import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.repository.UsuarioRepository;
import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.service.CorreoService;
import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.service.UsuarioService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final CorreoService correoService;

    public UsuarioServiceImpl(
            UsuarioRepository usuarioRepository,
            CorreoService correoService) {

        this.usuarioRepository = usuarioRepository;
        this.correoService = correoService;
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

        boolean usuarioNuevo = usuario.getId() == null;

        usuarioRepository.save(usuario);

        if (usuarioNuevo) {

            try {

                correoService.enviarBienvenida(
                        usuario.getEmail(),
                        usuario.getNombre()
                );

            } catch (Exception errorCorreo) {

                System.out.println(
                        "No fue posible enviar el correo de bienvenida: "
                        + errorCorreo.getMessage()
                );
            }
        }
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