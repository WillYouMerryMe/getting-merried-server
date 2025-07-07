package org.example.married.domain.attendee.presentation.dto.request

import org.example.married.domain.attendee.domain.type.MealPreference

data class UpdateAttendeeRequest(
    val attendeeId: String,
    val numberOfAttendees: Int,
    val isAttending: Boolean,
    val hasSentGift: Boolean,
    val mealPreference: MealPreference,
)
