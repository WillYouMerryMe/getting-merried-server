package org.example.married.domain.auth.presentation.dto.request

import org.example.married.domain.user.domain.type.Provider

data class CodeRequest(
    val code: String,
    val provider: Provider,
)
