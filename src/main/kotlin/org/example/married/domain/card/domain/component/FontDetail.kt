package org.example.married.domain.card.domain.component

data class FontDetail(
    val label: String,
    val value: String,
)

data class FontDetailDto(
    val label: String,
    val value: String,
) {
    fun toFontDetail(): FontDetail {
        return FontDetail(
            label = label,
            value = value,
        )
    }
}
