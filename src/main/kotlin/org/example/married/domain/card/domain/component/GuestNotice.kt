package org.example.married.domain.card.domain.component

data class GuestNotice(
    val title: String? = null,
    val content: String,
)

data class GuestNoticeDto(
    val title: String? = null,
    val content: String,
) {
    fun toGuestNotice(): GuestNotice {
        return GuestNotice(
            title = title,
            content = content,
        )
    }
}
