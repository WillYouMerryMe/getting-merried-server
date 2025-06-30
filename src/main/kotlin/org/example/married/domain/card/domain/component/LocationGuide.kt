package org.example.married.domain.card.domain.component

data class LocationGuide(
    val address: String,
    val isSubway: Boolean,
    val subwayDetail: String? = null,
    val isBus: Boolean,
    val busDetail: String? = null,
    val hasParking: Boolean,
    val parkingDetail: String? = null,
)

data class LocationGuideDto(
    val address: String,
    val isSubway: Boolean,
    val subwayDetail: String? = null,
    val isBus: Boolean,
    val busDetail: String? = null,
    val hasParking: Boolean,
    val parkingDetail: String? = null,
) {
    fun toLocationGuide(): LocationGuide {
        return LocationGuide(
            address = address,
            isSubway = isSubway,
            subwayDetail = subwayDetail,
            isBus = isBus,
            busDetail = busDetail,
            hasParking = hasParking,
            parkingDetail = parkingDetail,
        )
    }
}
