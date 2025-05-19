package org.example.married.domain.card.domain.component

data class GroomProfile(
    val name: String,
    val fatherName: String? = null,
    val isFatherDeceased: Boolean? = null,
    val motherName: String? = null,
    val isMotherDeceased: Boolean? = null,
)
