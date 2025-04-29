package org.example.married.global.security.exception
import org.example.married.global.error.exception.BusinessException
import org.example.married.global.error.exception.ErrorCode

class InvalidJwtTokenException(
    detail: String? = null,
): BusinessException(
    errorCode = ErrorCode.INVALID_JWT,
    detail = detail,
)
