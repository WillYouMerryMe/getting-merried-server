package org.example.married.domain.card.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.example.married.domain.card.presentation.dto.response.GetCardResponse
import org.springframework.http.ResponseEntity

@Tag(name = "Card API")
interface QueryCardController {

    @Operation(
        summary = "카드 조회 API 입니다.",
        description = "카드의 id를 보내 자신의 카드를 조회할 수 있습니다.",
    )
    fun getById(
        id: Long,
    ): ResponseEntity<GetCardResponse>
}