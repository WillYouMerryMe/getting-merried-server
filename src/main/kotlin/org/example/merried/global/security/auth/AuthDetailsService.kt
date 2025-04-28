package org.example.merried.global.security.auth

import org.example.merried.domain.user.domain.repository.UserRepository
import org.example.merried.domain.user.domain.repository.findByEmailOrThrow
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    private val userRepository: UserRepository,
): UserDetailsService {
    override fun loadUserByUsername(email: String): UserDetails {
        return AuthDetails(
            userRepository.findByEmailOrThrow(email)
        )
    }
}