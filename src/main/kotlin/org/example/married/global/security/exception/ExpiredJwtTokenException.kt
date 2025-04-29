package org.example.married.global.security.exception
import org.example.married.global.error.exception.BusinessException
import org.example.married.global.error.exception.ErrorCode

class ExpiredJwtTokenException(
    detail: String? = null,
): BusinessException(
    errorCode = ErrorCode.EXPIRED_JWT,
    detail = detail,
)
