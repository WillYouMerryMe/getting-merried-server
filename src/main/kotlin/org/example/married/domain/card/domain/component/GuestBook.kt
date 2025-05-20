package org.example.married.domain.card.domain.component

data class GuestBook(
    val title: String? = null,
    val masterPassword: String,
)

data class GuestBookDto(
    val title: String? = null,
    val masterPassword: String,
) {
    fun toGuestBook(): GuestBook {
        return GuestBook(
            title = title,
            masterPassword = masterPassword,
        )
    }
}
