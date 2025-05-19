package org.example.married.domain.card.domain

data class LocationGuide(
    val address: String,
    val isSubway: Boolean,
    val isBus: Boolean,
    val hasParking: Boolean,
)
