package org.example.married.domain.guestbook.presentation.dto.response

import org.example.married.domain.guestbook.domain.GuestBook

data class GetGuestBookListResponse(
    val name: String,
) {
    companion object {
        fun from(guestBook: GuestBook): GetGuestBookListResponse {
            return GetGuestBookListResponse(
                name = guestBook.name,
            )
        }
    }
}
