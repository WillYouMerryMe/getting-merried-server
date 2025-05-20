package org.example.married.domain.card.domain.component

data class BrideProfile(
    val name: String,
    val fatherName: String? = null,
    val isFatherDeceased: Boolean? = null,
    val motherName: String? = null,
    val isMotherDeceased: Boolean? = null,
)

data class BrideProfileDto(
    val name: String,
    val fatherName: String? = null,
    val isFatherDeceased: Boolean? = null,
    val motherName: String? = null,
    val isMotherDeceased: Boolean? = null,
) {
    fun toBrideProfile(): BrideProfile {
        return BrideProfile(
            name = name,
            fatherName = fatherName,
            isFatherDeceased = isFatherDeceased,
            motherName = motherName,
            isMotherDeceased = isMotherDeceased,
        )
    }
}
