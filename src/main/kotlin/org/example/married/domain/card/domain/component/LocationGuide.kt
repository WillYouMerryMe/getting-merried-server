package org.example.married.domain.card.domain.component

data class LocationGuide(
    val address: String,
    val isSubway: Boolean,
    val isBus: Boolean,
    val hasParking: Boolean,
)

data class LocationGuideDto(
    val address: String,
    val isSubway: Boolean,
    val isBus: Boolean,
    val hasParking: Boolean,
) {
    fun toLocationGuide(): LocationGuide {
        return LocationGuide(
            address = address,
            isSubway = isSubway,
            isBus = isBus,
            hasParking = hasParking,
        )
    }
}
