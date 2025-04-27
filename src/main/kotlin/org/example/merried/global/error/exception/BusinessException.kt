package org.example.merried.global.error.exception

class BusinessException(
    val errorCode: ErrorCode,
    val detail: String? = null,
): RuntimeException()
