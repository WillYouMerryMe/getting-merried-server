package org.example.married.domain.user.domain.facade

import org.example.married.domain.user.domain.User
import org.example.married.domain.user.exception.UserNotFoundException
import org.example.married.global.annotation.Facade
import org.example.married.global.security.auth.AuthDetails
import org.springframework.security.core.context.SecurityContextHolder

@Facade
class UserFacade {

    companion object {
        fun getCurrentUser(): User {
            val principal = SecurityContextHolder.getContext().authentication.principal

            if (principal is AuthDetails) {
                return principal.user
            }

            throw UserNotFoundException()
        }
    }
}