package org.example.married.domain.auth.presentation

import org.example.married.domain.auth.presentation.dto.request.CodeRequest
import org.example.married.domain.auth.presentation.dto.request.LogoutRefreshTokenRequest
import org.example.married.domain.auth.presentation.dto.request.ReissueRefreshTokenRequest
import org.example.married.domain.auth.presentation.dto.response.TokenResponse
import org.example.married.domain.auth.service.CommandAuthService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun reissueRefreshToken(
        @RequestBody request: ReissueRefreshTokenRequest,
    ) {
        commandAuthService.reissueRefreshToken(request)
    }

    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun logout(
        @RequestBody request: LogoutRefreshTokenRequest,
    ) {
        commandAuthService.logout(request)
    }
}