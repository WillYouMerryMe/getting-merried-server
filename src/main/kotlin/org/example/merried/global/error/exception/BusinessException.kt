package org.example.merried.global.error.exception

abstract class BusinessException(
    val errorCode: ErrorCode,
    val detail: String? = null,
): RuntimeException()
