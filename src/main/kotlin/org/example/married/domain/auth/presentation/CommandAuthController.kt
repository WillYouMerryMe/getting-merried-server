package org.example.married.domain.auth.presentation

import org.example.married.domain.auth.presentation.dto.request.CodeRequest
import org.example.married.domain.auth.presentation.dto.request.ReissueRefreshTokenRequest
import org.example.married.domain.auth.presentation.dto.response.TokenResponse
import org.example.married.domain.auth.service.CommandAuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/auth")
@RestController
class CommandAuthController(
    private val commandAuthService: CommandAuthService,
) {
    @PostMapping("/login")
    fun login(
        @RequestBody request: CodeRequest,
    ): ResponseEntity<TokenResponse> {
        val result = commandAuthService.login(request)
        return ResponseEntity.ok(result)
    }

    @PostMapping
    fun reissueRefreshToken(
        @RequestBody request: ReissueRefreshTokenRequest
    ) {
        commandAuthService.reissueRefreshToken(request)
    }
}