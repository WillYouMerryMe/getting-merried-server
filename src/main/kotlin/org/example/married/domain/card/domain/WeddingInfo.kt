package org.example.married.domain.card.domain

import java.time.LocalDateTime

data class WeddingInfo(
    val date: LocalDateTime,
    val weddingHallName: String,
    val isCalendarVisible: Boolean,
)
