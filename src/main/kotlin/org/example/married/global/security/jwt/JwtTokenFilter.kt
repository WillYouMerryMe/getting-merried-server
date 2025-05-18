package org.example.married.global.security.jwt

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.example.married.global.error.ErrorResponse
import org.example.married.global.error.exception.BusinessException
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class JwtTokenFilter(
    private val jwtTokenProvider: JwtTokenProvider,
    private val objectMapper: ObjectMapper,
): OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        jwtTokenProvider.extractToken(request)?.let { token ->
            try {
                val authentication = jwtTokenProvider.getAuthentication(token)
                SecurityContextHolder.getContext().authentication = authentication
            } catch (exception: BusinessException) {
                val errorResponse = ErrorResponse.of(
                    request = request,
                    exception = exception
                )
                errorResponse.errorLogging()

                response.status = errorResponse.status.value()
                response.contentType = "application/json;charset=UTF-8"

                response.writer.write(
                    objectMapper.writeValueAsString(errorResponse)
                )
                return
            }
        }

        filterChain.doFilter(request, response)
    }
}