package org.example.married.domain.guestbook.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.example.married.domain.guestbook.presentation.dto.request.CreateGuestBookRequest
import org.springframework.http.ResponseEntity

@Tag(name = "GuestBook API")
interface CommandGuestBookController {

    @Operation(
        summary = "방명록 등록 API 입니다. | accessToken X",
        description = "이름과 내용을 보낼시 방명록을 등록합니다.",
    )
    fun createGuestBook(
        request: CreateGuestBookRequest,
    ): ResponseEntity<Void>
}