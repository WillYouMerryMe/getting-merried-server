package org.example.married.domain.attendee.exception
import org.example.married.global.error.exception.BusinessException
import org.example.married.global.error.exception.ErrorCode

class AttendeeNotFoundException(
    detail: String? = null,
): BusinessException(
    errorCode = ErrorCode.ATTENDEE_NOT_FOUND,
    detail = detail,
)
