package org.example.married.domain.card.exception
import org.example.married.global.error.exception.BusinessException
import org.example.married.global.error.exception.ErrorCode

class CardNotFoundException(
    detail: String? = null,
): BusinessException(
    errorCode = ErrorCode.CARD_NOT_FOUND,
    detail = detail,
)
