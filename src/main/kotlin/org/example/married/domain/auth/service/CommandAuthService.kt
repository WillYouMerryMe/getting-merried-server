package org.example.married.domain.auth.service

import org.example.married.domain.auth.domain.repository.RefreshTokenRepository
import org.example.married.domain.auth.facade.AuthFacade
import org.example.married.domain.auth.presentation.dto.request.CodeRequest
import org.example.married.domain.auth.presentation.dto.request.LogoutRefreshTokenRequest
import org.example.married.domain.auth.presentation.dto.request.ReissueRefreshTokenRequest
import org.example.married.domain.auth.presentation.dto.response.TokenResponse
import org.example.married.domain.user.domain.User
import org.example.married.domain.user.domain.repository.UserRepository
import org.example.married.global.annotation.CustomService
import org.example.married.global.security.exception.InvalidJwtTokenException
import org.example.married.global.security.jwt.JwtTokenProvider
import org.springframework.data.repository.findByIdOrNull

@CustomService
class CommandAuthService(
    private val authFacade: AuthFacade,
    private val userRepository: UserRepository,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtTokenProvider: JwtTokenProvider,
) {
    fun login(request: CodeRequest): TokenResponse {
        val userInfo = authFacade.getUserInfo(request.code, request.provider, request.redirectUri)

        userRepository.findByEmail(userInfo.email) ?: run {
            val user = User(
                email = userInfo.email,
                nickname = userInfo.nickname,
                profileImg = userInfo.profileImg,
                provider = request.provider,
            )

            userRepository.save(user)
        }

        return TokenResponse(
            jwtTokenProvider.createAccessToken(userInfo.email),
            jwtTokenProvider.createRefreshToken(userInfo.email),
            request.provider,
        )
    }

    fun reissueRefreshToken(request: ReissueRefreshTokenRequest): String {
        val email = jwtTokenProvider.getSubject(request.token)

        refreshTokenRepository.findByIdOrNull(request.token)
            ?: throw InvalidJwtTokenException(request.token)

        return jwtTokenProvider.createRefreshToken(email)
    }

    fun logout(request: LogoutRefreshTokenRequest) {
        val refreshToken = refreshTokenRepository.findByIdOrNull(request.token)
            ?: throw InvalidJwtTokenException(request.token)

        refreshTokenRepository.delete(refreshToken)
    }

    fun deleteUser(cUser: User) {
        userRepository.delete(cUser)
    }
}