package org.example.married.domain.auth.presentation.impl

import org.example.married.domain.auth.presentation.CommandAuthController
import org.example.married.domain.auth.presentation.dto.request.CodeRequest
import org.example.married.domain.auth.presentation.dto.request.LogoutRefreshTokenRequest
import org.example.married.domain.auth.presentation.dto.request.ReissueRefreshTokenRequest
import org.example.married.domain.auth.presentation.dto.response.TokenResponse
import org.example.married.domain.auth.service.CommandAuthService
import org.example.married.domain.user.domain.facade.UserFacade
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/auth")
@RestController
class CommandAuthControllerImpl(
    private val commandAuthService: CommandAuthService,
) : CommandAuthController {

    @PostMapping("/login")
    override fun login(
        @RequestBody request: CodeRequest,
    ): ResponseEntity<TokenResponse> {
        val result = commandAuthService.login(request)
        return ResponseEntity.ok(result)
    }

    @PostMapping("/reissue")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    override fun reissueRefreshToken(
        @RequestBody request: ReissueRefreshTokenRequest,
    ): ResponseEntity<String> {
        val result = commandAuthService.reissueRefreshToken(request)
        return ResponseEntity.ok(result)
    }

    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    override fun logout(
        @RequestBody request: LogoutRefreshTokenRequest,
    ): ResponseEntity<Void> {
        commandAuthService.logout(request)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    override fun deleteUser(
    ): ResponseEntity<Void> {
        commandAuthService.deleteUser(UserFacade.getCurrentUser())
        return ResponseEntity.noContent().build()
    }
}