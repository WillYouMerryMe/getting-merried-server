package org.example.married.domain.attendee.presentation.dto.request

data class GetAttendeesRequest(
    val isAttendee: Boolean? = null,
    val hasSentGift: Boolean? = null,
    val isEating: Boolean? = null,
)
