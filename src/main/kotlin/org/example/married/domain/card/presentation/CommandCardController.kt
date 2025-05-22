package org.example.married.domain.card.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.example.married.domain.card.presentation.dto.request.CreateCardRequest
import org.springframework.http.ResponseEntity

@Tag(name = "Card API")
interface CommandCardController {

    @Operation(
        summary = "카드 등록 API 입니다.",
        description = "각 객체별로 빈 값이면 null로 보내야함, 각 객체마다 순서 매기기",
    )
    fun createCard(
        request: CreateCardRequest,
    ): ResponseEntity<String>
}
