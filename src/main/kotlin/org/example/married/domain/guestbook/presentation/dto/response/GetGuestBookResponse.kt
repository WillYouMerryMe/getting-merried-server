package org.example.married.domain.guestbook.presentation.dto.response

import org.example.married.domain.guestbook.domain.GuestBook

data class GetGuestBookResponse(
    val id: String,
    val name: String,
    val content: String,
) {
    companion object {
        fun from(guestBook: GuestBook): GetGuestBookResponse {
            return GetGuestBookResponse(
                id = guestBook.id,
                name = guestBook.name,
                content = guestBook.content,
            )
        }
    }
}
