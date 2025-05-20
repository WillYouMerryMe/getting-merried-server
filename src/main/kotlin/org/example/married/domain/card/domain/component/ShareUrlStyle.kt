package org.example.married.domain.card.domain.component

data class ShareUrlStyle(
    val thumbnailUrl: String,
    val title: String? = null,
    val content: String? = null,
)

data class ShareUrlStyleDto(
    val thumbnailUrl: String,
    val title: String? = null,
    val content: String? = null,
) {
    fun toShareUrlStyle(): ShareUrlStyle {
        return ShareUrlStyle(
            thumbnailUrl = thumbnailUrl,
            title = title,
            content = content,
        )
    }
}
