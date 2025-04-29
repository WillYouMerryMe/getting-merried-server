package org.example.married.global.error

import jakarta.servlet.http.HttpServletRequest
import org.example.married.global.error.exception.BusinessException
import org.example.married.global.error.exception.ErrorCode
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ErrorResponse(
    val status: HttpStatus,
    val message: String,
    val detail: Any? = null,
    val path: String,
    val ip: String,
    val timestamp: String = LocalDateTime.now().toString(),
) {
    companion object {
        private val log = LoggerFactory.getLogger(ErrorResponse::class.java)!!

        fun of(
            request: HttpServletRequest,
            exception: BusinessException,
        ): ErrorResponse {
            return ErrorResponse(
                status = exception.errorCode.status,
                message = exception.errorCode.message,
                detail = exception.detail,
                path = "${request.method} ${request.requestURI}",
                ip = getClientIp(request),
            )
        }

        fun of(
            request: HttpServletRequest,
            errorCode: ErrorCode,
            detail: Any? = null,
        ): ErrorResponse {
            return ErrorResponse(
                status = errorCode.status,
                message = errorCode.message,
                detail = detail,
                path = "${request.method} ${request.requestURI}",
                ip = getClientIp(request),
            )
        }

        private fun getClientIp(request: HttpServletRequest): String {
            val xfHeader = request.getHeader("X-Forwarded-For")
            return if (xfHeader != null && xfHeader.isNotEmpty()) {
                xfHeader.split(",")[0]
            } else {
                request.remoteAddr
            }
        }
    }

    fun errorLogging() {
        log.error(">> Path=$path, ErrorCode=$status, Message=$message, Detail=$detail, ClientIP=$ip")
    }
}