package org.example.married.domain.card.domain.component

data class PhotoGallery(
    val title: String,
    val urls: List<String>,
)

data class PhotoGalleryDto(
    val title: String,
    val urls: List<String>,
) {
    fun toPhotoGallery(): PhotoGallery {
        return PhotoGallery(
            title = title,
            urls = urls,
        )
    }
}
