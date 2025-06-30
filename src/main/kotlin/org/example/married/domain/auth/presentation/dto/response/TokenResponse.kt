package org.example.married.domain.auth.presentation.dto.response

import org.example.married.domain.user.domain.type.Provider

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val provider: Provider,
)
