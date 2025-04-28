package org.example.merried.global.security.jwt

import io.jsonwebtoken.*
import io.jsonwebtoken.security.Keys
import jakarta.servlet.http.HttpServletRequest
import org.example.merried.domain.auth.domain.RefreshToken
import org.example.merried.domain.auth.domain.repository.RefreshTokenRepository
import org.example.merried.global.config.properties.JwtProperties
import org.example.merried.global.security.auth.AuthDetailsService
import org.example.merried.global.security.exception.ExpiredJwtTokenException
import org.example.merried.global.security.exception.InvalidJwtTokenException
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService,
    private val refreshTokenRepository: RefreshTokenRepository,
) {
    private val secretKey = convertToKey(jwtProperties.secretKey)

    fun createAccessToken(email: String): String {
        return Jwts.builder()
            .setIssuer("merried")
            .setSubject(email)
            .setIssuedAt(Date())
            .setExpiration(convertToExpirationDate(jwtProperties.accessTime))
            .claim("isRefresh", false)
            .signWith(secretKey, SignatureAlgorithm.HS256)
            .compact()
    }

    fun createRefreshToken(email: String): String {
        val token = Jwts.builder()
            .setIssuer("merried")
            .setSubject(email)
            .setIssuedAt(Date())
            .setExpiration(convertToExpirationDate(jwtProperties.refreshTime))
            .claim("isRefresh", true)
            .signWith(secretKey, SignatureAlgorithm.HS256)
            .compact()
        refreshTokenRepository.save(RefreshToken(token, email, jwtProperties.refreshTime))

        return token
    }

    fun extractToken(request: HttpServletRequest): String? {
        val bearer: String = request.getHeader(HttpHeaders.AUTHORIZATION)
            ?: return null

        if (bearer.startsWith(BEARER).not()) {
            return null
        }

        return bearer.split(WHITESPACE)[1]
    }

    fun getAuthentication(token: String): UsernamePasswordAuthenticationToken {
        val userDetails = authDetailsService.loadUserByUsername(getSubject(token))
        return UsernamePasswordAuthenticationToken(userDetails, userDetails.authorities)
    }

    private fun getSubject(token: String): String {
        return getTokenBody(token).body.subject
    }

    private fun getTokenBody(token: String): Jws<Claims> {
        try {
            return Jwts.parserBuilder()
                .setSigningKey(secretKey).build()
                .parseClaimsJws(token)
        } catch (e: ExpiredJwtException) {
            throw ExpiredJwtTokenException(token)
        } catch (e: Exception) {
            throw InvalidJwtTokenException(token)
        }
    }

    companion object {
        private const val BEARER = "Bearer "
        private const val WHITESPACE = " "

        fun convertToKey(secretKey: String): Key {
            return Keys.hmacShaKeyFor(secretKey.toByteArray())
        }

        fun convertToExpirationDate(expiration: Long): Date {
            return Date(Date().time + expiration)
        }
    }
}
