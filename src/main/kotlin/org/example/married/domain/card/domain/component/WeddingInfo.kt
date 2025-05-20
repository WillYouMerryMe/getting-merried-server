package org.example.married.domain.card.domain.component

import java.time.LocalDateTime

data class WeddingInfo(
    val date: LocalDateTime,
    val weddingHallName: String,
    val isCalendarVisible: Boolean,
)

data class WeddingInfoDto(
    val date: LocalDateTime,
    val weddingHallName: String,
    val isCalendarVisible: Boolean,
) {
    fun toWeddingInfo(): WeddingInfo {
        return WeddingInfo(
            date = date,
            weddingHallName = weddingHallName,
            isCalendarVisible = isCalendarVisible,
        )
    }
}
