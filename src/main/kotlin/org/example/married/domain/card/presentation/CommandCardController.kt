package org.example.married.domain.card.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.example.married.domain.card.presentation.dto.request.CreateCardRequest
import org.example.married.domain.card.presentation.dto.request.UpdateCardRequest
import org.example.married.domain.card.presentation.dto.response.CreateCardResponse
import org.example.married.domain.card.presentation.dto.response.UpdateCardResponse
import org.springframework.http.ResponseEntity

@Tag(name = "Card API")
interface CommandCardController {

    @Operation(
        summary = "카드 등록 API 입니다.",
        description = "각 객체별로 빈 값이면 null로 보내야함, 각 객체마다 순서 매기기",
    )
    fun createCard(
        request: CreateCardRequest,
    ): ResponseEntity<CreateCardResponse>

    @Operation(
        summary = "카드 수정 API 입니다.",
        description = "각 객체별로 빈 값이면 null로 보내야함, 각 객체마다 순서 매기기",
    )
    fun updateCard(
        request: UpdateCardRequest,
    ): ResponseEntity<UpdateCardResponse>

    @Operation(
        summary = "카드 삭제 API 입니다.",
        description = "카드 id를 가지고 자신의 카드를 삭제할 수 있습니다.",
    )
    fun deleteCard(
        id: String,
    ): ResponseEntity<Void>
}
