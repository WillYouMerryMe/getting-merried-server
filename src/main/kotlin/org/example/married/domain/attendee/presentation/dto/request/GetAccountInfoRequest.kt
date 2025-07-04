package org.example.married.domain.attendee.presentation.dto.request

data class GetAccountInfoRequest(
    val cardId: String,
    val name: String,
    val phoneNumber: String,
)
