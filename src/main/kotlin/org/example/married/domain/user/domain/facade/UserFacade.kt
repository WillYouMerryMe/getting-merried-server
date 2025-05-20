package org.example.married.domain.user.domain.facade

import org.example.married.domain.user.domain.User
import org.example.married.domain.user.domain.repository.UserRepository
import org.example.married.domain.user.domain.repository.findByEmailOrThrow
import org.example.married.global.annotation.Facade
import org.springframework.security.core.context.SecurityContextHolder

@Facade
class UserFacade(
    private val userRepository: UserRepository,
) {
    fun getCurrentUser(): User {
        val email: String = SecurityContextHolder.getContext().authentication.name
        return userRepository.findByEmailOrThrow(email)
    }
}