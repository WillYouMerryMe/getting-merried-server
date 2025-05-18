package org.example.married.domain.card.domain

import org.example.married.global.entity.BaseEntity
import org.springframework.data.mongodb.core.mapping.Document

@Document("cards")
data class Card(
    val userId: Long,
): BaseEntity()
