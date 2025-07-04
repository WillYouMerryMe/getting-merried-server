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
    val side: Side? = null,
    val numberOfAttendees: Int = 1,
    val mealPreference: MealPreference? = null,
    val cardId: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    var deletedAt: LocalDateTime? = null,
) {
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
            side = side,
            numberOfAttendees = numberOfAttendees,
            mealPreference = mealPreference,
            updatedAt = LocalDateTime.now(),
        )
    }
}
