package org.example.married.domain.card.domain.component

data class PhotoGallery(
    val title: String? = null,
    val url: List<String>? = null,
)

data class PhotoGalleryDto(
    val title: String? = null,
    val url: List<String>? = null,
) {
    fun toPhotoGallery(): PhotoGallery {
        return PhotoGallery(
            title = title,
            url = url,
        )
    }
}
