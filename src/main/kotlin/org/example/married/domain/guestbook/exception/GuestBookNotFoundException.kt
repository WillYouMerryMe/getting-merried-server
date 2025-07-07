package org.example.married.domain.guestbook.exception
import org.example.married.global.error.exception.BusinessException
import org.example.married.global.error.exception.ErrorCode

class GuestBookNotFoundException(
    detail: String? = null,
): BusinessException(
    errorCode = ErrorCode.GUEST_BOOK_NOT_FOUND,
    detail = detail,
)
