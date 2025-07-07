package org.example.married.domain.guestbook.presentation.dto.request

data class CreateGuestBookRequest(
    val cardId: String,
    val name: String,
    val content: String,
) {
}