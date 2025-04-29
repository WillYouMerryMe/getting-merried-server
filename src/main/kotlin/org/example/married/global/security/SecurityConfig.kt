package org.example.married.global.security

import org.apache.catalina.webresources.TomcatURLStreamHandlerFactory.disable
import org.example.married.global.security.jwt.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtTokenProvider: JwtTokenProvider,
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { disable() }
            .httpBasic { disable() }
            .formLogin { disable() }
            .logout { disable() }

        http
            .sessionManagement { session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }

        http
            .cors(Customizer.withDefaults())
            .authorizeHttpRequests{ auth -> auth
                .anyRequest().authenticated()
            }

        http
            .with(FilterConfig(jwtTokenProvider), FilterConfig::build)

        return http.build()
    }
}