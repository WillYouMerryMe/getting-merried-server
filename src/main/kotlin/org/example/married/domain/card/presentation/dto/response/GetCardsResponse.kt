package org.example.married.domain.card.presentation.dto.response

import org.example.married.domain.card.domain.Card
import java.time.LocalDateTime

data class GetCardsResponse(
    val id: String,
    val title: String,
    val picture: String,
    val updateAt: LocalDateTime,
) {
    companion object {
        fun of(
            card: Card,
        ): GetCardsResponse {
            return GetCardsResponse(
                id = card.id,
                title = card.title,
                picture = card.mainPageSetting.picture,
                updateAt = card.updatedAt,
            )
        }
    }
}