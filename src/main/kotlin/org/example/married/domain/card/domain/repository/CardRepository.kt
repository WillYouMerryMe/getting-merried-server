package org.example.married.domain.card.domain.repository

import org.example.married.domain.card.domain.Card
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CardRepository: MongoRepository<Card, Long> {
}