package cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.serviceimpl;

import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.domain.Usuario;
import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuario no encontrado"));

        return User.builder()
                .username(usuario.getEmail())
                .password("{noop}" + usuario.getPassword())
                .roles(usuario.getRol().getNombre())
                .disabled(!usuario.isActivo())
                .build();
    }
}