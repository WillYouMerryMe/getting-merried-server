package org.example.married.domain.guestbook.presentation.dto.response

import org.example.married.domain.guestbook.domain.GuestBook

data class GetGuestBookResponse(
    val name: String,
    val content: String,
) {
    companion object {
        fun from(guestBook: GuestBook): GetGuestBookResponse {
            return GetGuestBookResponse(
                name = guestBook.name,
                content = guestBook.content,
            )
        }
    }
}
