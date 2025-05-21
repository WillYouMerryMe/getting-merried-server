package org.example.married.domain.card.service

import org.example.married.domain.card.domain.repository.CardRepository
import org.example.married.domain.card.exception.CardNotFoundException
import org.example.married.domain.card.presentation.dto.response.GetCardResponse
import org.example.married.domain.user.domain.User
import org.example.married.global.annotation.CustomService

@CustomService(readOnly = true)
class QueryCardService(
    private val cardRepository: CardRepository,
) {
    fun getCardById(
        cardId: Long,
        user: User,
    ): GetCardResponse {
        val card = cardRepository.findByIdAndUserId(cardId, user.id)
            ?: throw CardNotFoundException()

        return GetCardResponse.of(card)
    }
}