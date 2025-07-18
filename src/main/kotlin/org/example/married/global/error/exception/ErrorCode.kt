package org.example.married.global.error.exception

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val status: HttpStatus,
    val message: String,
) {
    // user
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찾지 못 하였습니다."),

    // guestBook
    GUEST_BOOK_NOT_FOUND(HttpStatus.NOT_FOUND, "방명록을 찾지 못 하였습니다."),

    // guestSnapshot
    GUEST_SNAPSHOT_NOT_FOUND(HttpStatus.NOT_FOUND, "방명록을 찾지 못 하였습니다."),

    // card
    CARD_NOT_FOUND(HttpStatus.NOT_FOUND, "카드를 찾지 못 하였습니다."),

    // attendee
    ATTENDEE_NOT_FOUND(HttpStatus.NOT_FOUND, "참석자를 찾지 못 하였습니다."),
    ATTENDEE_ALREADY(HttpStatus.CONFLICT, "이미 참석자가 추가되었습니다."),

    // jwt
    EXPIRED_JWT(HttpStatus.UNAUTHORIZED, "만료된 토큰입니다."),
    INVALID_JWT(HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰입니다."),

    // server
    AUTH_REQUIRED(HttpStatus.UNAUTHORIZED, "인증이 필요한 요청입니다."),
    PERMISSION_DENIED(HttpStatus.FORBIDDEN, "권한이 없습니다."),
    NOT_SUPPORTED_URI_ERROR(HttpStatus.NOT_FOUND, "잘못된 요청입니다."),
    NOT_SUPPORTED_METHOD_ERROR(HttpStatus.METHOD_NOT_ALLOWED, "잘못된 요청입니다."),
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    UNSUPPORTED_MEDIA_TYPE_ERROR(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "잘못된 요청입니다."),
    UNEXPECTED_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류입니다."),
}