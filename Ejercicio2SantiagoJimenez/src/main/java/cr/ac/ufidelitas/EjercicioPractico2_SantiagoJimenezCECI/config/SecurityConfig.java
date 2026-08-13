package cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.config;

import cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.serviceimpl.UsuarioDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
                .authorizeHttpRequests(auth -> auth

                .requestMatchers("/", "/login").permitAll()

                .requestMatchers("/usuarios/**", "/roles/**")
                .hasRole("ADMIN")

                .requestMatchers("/citas/nueva",
                        "/citas/guardar",
                        "/citas/editar/**",
                        "/citas/eliminar/**")
                .hasAnyRole("ADMIN", "MEDICO")

                .requestMatchers("/citas/**", "/consultas/**")
                .hasAnyRole("ADMIN", "MEDICO", "PACIENTE")

                .anyRequest().authenticated()
                )

                .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/redireccion", true)
                .permitAll()
                )

                .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                );

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration)
            throws Exception {

        return configuration.getAuthenticationManager();
    }
}