package org.example.married.global.error.exception

abstract class BusinessException(
    val errorCode: ErrorCode,
    val detail: String? = null,
): RuntimeException()
