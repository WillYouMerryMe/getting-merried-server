package org.example.married.domain.attendee.presentation.dto.request

data class CreateAttendeeRequest(
    val cardId: String,
    val name: String,
    val phoneNumber: String,
    val isAttending: Boolean,
    val hasSentGift: Boolean,
    val isEating: Boolean,
)
