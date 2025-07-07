package org.example.married.domain.guestbook.presentation.dto.request

data class GetGuestBookRequest(
    val cardId: String,
    val password: String,
) {
}