package org.example.merried.domain.user.exception
import org.example.merried.global.error.exception.BusinessException
import org.example.merried.global.error.exception.ErrorCode

class UserNotFoundException(
    detail: String? = null,
): BusinessException(
    errorCode = ErrorCode.USER_NOT_FOUND,
    detail = detail,
)
