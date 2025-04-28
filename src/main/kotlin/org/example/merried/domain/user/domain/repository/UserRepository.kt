package org.example.merried.domain.user.domain.repository

import org.example.merried.domain.user.domain.User
import org.example.merried.domain.user.exception.UserNotFoundException
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}

fun UserRepository.findByEmailOrThrow(email: String): User {
    return findByEmail(email)
        ?: throw UserNotFoundException("$email not found")
}
