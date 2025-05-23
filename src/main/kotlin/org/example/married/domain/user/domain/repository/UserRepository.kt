package org.example.married.domain.user.domain.repository

import org.example.married.domain.user.domain.User
import org.example.married.domain.user.exception.UserNotFoundException
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: MongoRepository<User, String> {
    fun findByEmail(email: String): User?
}

fun UserRepository.findByEmailOrThrow(email: String): User {
    return findByEmail(email)
        ?: throw UserNotFoundException("$email not found")
}
