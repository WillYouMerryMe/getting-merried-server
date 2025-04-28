package org.example.merried.global.security.exception
import org.example.merried.global.error.exception.BusinessException
import org.example.merried.global.error.exception.ErrorCode

class ExpiredJwtTokenException(
    detail: String? = null,
): BusinessException(
    errorCode = ErrorCode.EXPIRED_JWT,
    detail = detail,
)
