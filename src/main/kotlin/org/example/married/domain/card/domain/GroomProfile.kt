package org.example.married.domain.card.domain

data class GroomProfile(
    val name: String,
    val fatherName: String? = null,
    val isFatherDeceased: Boolean? = null,
    val motherName: String? = null,
    val isMotherDeceased: Boolean? = null,
)
