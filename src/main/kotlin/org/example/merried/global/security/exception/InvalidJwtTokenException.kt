package org.example.merried.global.security.exception
import org.example.merried.global.error.exception.BusinessException
import org.example.merried.global.error.exception.ErrorCode

class InvalidJwtTokenException(
    detail: String? = null,
): BusinessException(
    errorCode = ErrorCode.INVALID_JWT,
    detail = detail,
)
