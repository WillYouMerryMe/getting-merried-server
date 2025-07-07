package org.example.married.domain.card.service

import org.example.married.domain.card.domain.repository.CardRepository
import org.example.married.domain.card.domain.repository.findByIdOrNull
import org.example.married.domain.card.presentation.dto.response.GetCardResponse
import org.example.married.domain.card.presentation.dto.response.GetCardsResponse
import org.example.married.domain.user.domain.User
import org.example.married.global.annotation.CustomService

@CustomService(readOnly = true)
class QueryCardService(
    private val cardRepository: CardRepository,
) {
    fun getCardById(
        cardId: String,
    ): GetCardResponse {
        val card = cardRepository.findByIdOrNull(cardId)

        return GetCardResponse.of(card)
    }

    fun getCards(
        user: User,
    ): List<GetCardsResponse> {
        val cards = cardRepository.findByUserId(user.id)

        return cards.map { GetCardsResponse.of(it) }
    }
}