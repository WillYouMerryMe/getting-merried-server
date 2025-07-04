package org.example.married.domain.attendee.presentation.dto.request

import org.example.married.domain.attendee.domain.type.MealPreference
import org.example.married.domain.attendee.domain.type.Side

data class GetAttendeeInfoRequest(
    val cardId: String,
    val side: Side,
    val name: String,
    val phoneNumber: String,
    val numberOfAttendees: Int,
    val mealPreference: MealPreference,
)
