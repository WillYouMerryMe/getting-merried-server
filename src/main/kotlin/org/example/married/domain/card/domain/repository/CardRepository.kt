package org.example.married.domain.card.domain.repository

import org.example.married.domain.card.domain.Card
import org.example.married.domain.card.exception.CardNotFoundException
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
interface CardRepository: MongoRepository<Card, String> {
    fun findByIdAndUserId(
        cardId: String,
        userId: String,
    ): Card?

    fun findByUserId(userId: String): List<Card>
}

fun CardRepository.findByIdOrNull(cardId: String): Card {
    return findByIdOrNull(cardId)
        ?: throw CardNotFoundException("Not found card = $cardId")
}
