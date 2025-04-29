package org.example.married.domain.auth.domain.repository

import org.example.married.domain.auth.domain.RefreshToken
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RefreshTokenRepository: CrudRepository<RefreshToken, String> {
}