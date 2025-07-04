package org.example.married.domain.attendee.presentation.dto.request

data class UpdateAttendeeRequest(
    val attendeeId: String,
    val isAttending: Boolean,
    val hasSentGift: Boolean,
    val isEating: Boolean,
)
