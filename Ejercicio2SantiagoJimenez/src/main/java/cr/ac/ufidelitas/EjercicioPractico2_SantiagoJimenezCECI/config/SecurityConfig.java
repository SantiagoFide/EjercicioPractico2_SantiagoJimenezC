package cr.ac.ufidelitas.EjercicioPractico2_SantiagoJimenezCECI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth

                .requestMatchers(
                    "/",
                    "/roles/**",
                    "/usuarios/**",
                    "/citas/**",
                    "/consultas/**"
                ).permitAll()

                .anyRequest().authenticated()
            )

            .formLogin(form -> form
                .permitAll()
            )

            .logout(logout -> logout
                .permitAll()
            );

        return http.build();
    }
}