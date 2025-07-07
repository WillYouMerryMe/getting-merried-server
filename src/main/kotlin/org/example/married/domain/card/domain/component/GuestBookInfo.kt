package org.example.married.domain.card.domain.component

data class GuestBookInfo(
    val title: String? = null,
    val masterPassword: String,
)

data class GuestBookDto(
    val title: String? = null,
    val masterPassword: String,
) {
    fun toGuestBook(): GuestBookInfo {
        return GuestBookInfo(
            title = title,
            masterPassword = masterPassword,
        )
    }
}
