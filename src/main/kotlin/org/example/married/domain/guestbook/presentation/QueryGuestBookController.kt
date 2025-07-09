package org.example.married.domain.guestbook.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.example.married.domain.guestbook.presentation.dto.request.GetGuestBookRequest
import org.example.married.domain.guestbook.presentation.dto.response.GetGuestBookListResponse
import org.example.married.domain.guestbook.presentation.dto.response.GetGuestBookResponse
import org.springframework.http.ResponseEntity

@Tag(name = "GuestBook API")
interface QueryGuestBookController {

    @Operation(
        summary = "방명록 조회 API 입니다.",
        description = "방명록의 정보를 보낼 시 내용을 확인할 수 있습니다.",
    )
    fun getGuestBooks(
        request: GetGuestBookRequest,
    ): ResponseEntity<List<GetGuestBookResponse>>

    @Operation(
        summary = "방명록 리스트 조회 API 입니다.",
        description = "방명록의 리스트를 확인할 수 있습니다.",
    )
    fun getGuestBookList(
        id: String,
    ): ResponseEntity<List<GetGuestBookListResponse>>
}