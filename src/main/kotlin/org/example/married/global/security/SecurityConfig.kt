package org.example.married.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import org.example.married.global.security.jwt.JwtTokenFilter
import org.example.married.global.security.jwt.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtTokenProvider: JwtTokenProvider,
    private val objectMapper: ObjectMapper,
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .httpBasic { it.disable() }
            .formLogin { it.disable() }
            .logout { it.disable() }

        http
            .sessionManagement { session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }

        http
            .cors(Customizer.withDefaults())
            .authorizeHttpRequests{ auth -> auth
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers(
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/v3/api-docs/swagger-config").permitAll()
                .anyRequest().authenticated()
            }

        http
            .addFilterBefore(JwtTokenFilter(jwtTokenProvider, objectMapper), UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }
}