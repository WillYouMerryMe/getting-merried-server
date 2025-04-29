package org.example.married.domain.user.exception
import org.example.married.global.error.exception.BusinessException
import org.example.married.global.error.exception.ErrorCode

class UserNotFoundException(
    detail: String? = null,
): BusinessException(
    errorCode = ErrorCode.USER_NOT_FOUND,
    detail = detail,
)
