package org.example.married.domain.auth.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.example.married.domain.auth.presentation.dto.request.CodeRequest
import org.example.married.domain.auth.presentation.dto.request.LogoutRefreshTokenRequest
import org.example.married.domain.auth.presentation.dto.request.ReissueRefreshTokenRequest
import org.example.married.domain.auth.presentation.dto.response.TokenResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody

@Tag(name = "Auth API")
interface CommandAuthController {

    @Operation(
        summary = "로그인을 진행하는 API 입니다.",
        description = "NAVER, KAKAO의 OAUTH를 사용하여 유저 로그인을 진행합니다.",
    )
    fun login(
        @RequestBody request: CodeRequest,
    ): ResponseEntity<TokenResponse>

    @Operation(
        summary = "accessToken재발급을 해주는 API 입니다.",
        description = "refreshToken을 보내 사용자의 refreshToken을 재발급 받을 수 있습니다.",
    )
    fun reissueRefreshToken(
        @RequestBody request: ReissueRefreshTokenRequest,
    )

    @Operation(
        summary = "로그아웃을 진행하는 API 입니다.",
        description = "회원의 refreshToken을 제공하여 다시 사용하지 못하도록 로그아웃을 진행합니다.",
    )
    fun logout(
        @RequestBody request: LogoutRefreshTokenRequest,
    )
}