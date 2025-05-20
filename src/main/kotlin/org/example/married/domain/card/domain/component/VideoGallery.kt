package org.example.married.domain.card.domain.component

data class VideoGallery(
    val title: String? = null,
    val url: String,
)

data class VideoGalleryDto(
    val title: String? = null,
    val url: String,
) {
    fun toVideoGallery(): VideoGallery {
        return VideoGallery(
            title = title,
            url = url,
        )
    }
}
