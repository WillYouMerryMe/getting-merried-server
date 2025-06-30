package org.example.married.domain.card.domain.component

import kotlin.String

data class PhotoGallery(
    val galleries: List<PhotoGalleryDetail>,
)

data class PhotoGalleryDetail(
    val title: String,
    val url: String,
)

data class PhotoGalleryDto(
    val galleries: List<PhotoGalleryDetail>,
) {
    fun toPhotoGallery(): PhotoGallery {
        return PhotoGallery(
            galleries = galleries
        )
    }
}

data class PhotoGalleryDetailDto(
    val title: String,
    val url: String,
) {
    fun toPhotoGallery(): PhotoGalleryDetail {
        return PhotoGalleryDetail(
            title = title,
            url = url,
        )
    }
}
