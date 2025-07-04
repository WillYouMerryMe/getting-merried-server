package org.example.married.domain.attendee.domain

import org.example.married.domain.attendee.domain.type.MealPreference
import org.example.married.domain.attendee.domain.type.Side
import org.example.married.global.util.generateDocumentId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("attendees")
data class Attendee(
    @Id
    val id: String = generateDocumentId(),
    val name: String,
    val phoneNumber: String,
    val isAttending: Boolean = false,
    val hasSentGift: Boolean = false,
    val isEating: Boolean = false,
    val side: Side? = null,
    val numberOfAttendees: Int? = null,
    val mealPreference: MealPreference? = null,
    val cardId: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    var deletedAt: LocalDateTime? = null,
)
