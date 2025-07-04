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
    val numberOfAttendees: Int = 1,
    val mealPreference: MealPreference? = null,
    val cardId: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    var deletedAt: LocalDateTime? = null,
) {
    fun update(
        isAttending: Boolean,
        hasSentGift: Boolean,
        isEating: Boolean,
    ):Attendee {
        return this.copy(
            isAttending = isAttending,
            hasSentGift = hasSentGift,
            isEating = isEating,
            updatedAt = LocalDateTime.now(),
        )
    }

    fun updateAccountInfo():Attendee {
        return this.copy(
            hasSentGift = true,
            updatedAt = LocalDateTime.now(),
        )
    }

    fun updateAttendeeInfo(
        side: Side,
        numberOfAttendees: Int,
        mealPreference: MealPreference,
    ):Attendee {
        return this.copy(
            isAttending = true,
            isEating = mealPreference.isEating,
            side = side,
            numberOfAttendees = numberOfAttendees,
            mealPreference = mealPreference,
            updatedAt = LocalDateTime.now(),
        )
    }
}
