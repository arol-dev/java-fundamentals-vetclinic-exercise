package com.acuadrado.vetclinic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // Desactivamos CSRF (no tenemos formularios HTML)
                .csrf(AbstractHttpConfigurer::disable)

                // Autorización de endpoints
                .authorizeHttpRequests(auth -> auth
                        // GET públicos
                        .requestMatchers(HttpMethod.GET, "/owners", "/pets", "/visits").permitAll()
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        // El resto requiere token (POST /owners, /pets, /visits…)
                        .anyRequest().authenticated()
                )

                // Activar Resource Server con JWT (Auth0)
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));

        return http.build();
    }
}
