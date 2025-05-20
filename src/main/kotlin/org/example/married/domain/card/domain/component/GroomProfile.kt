package org.example.married.domain.card.domain.component

data class GroomProfile(
    val name: String,
    val fatherName: String? = null,
    val isFatherDeceased: Boolean? = null,
    val motherName: String? = null,
    val isMotherDeceased: Boolean? = null,
)

data class GroomProfileDto(
    val name: String,
    val fatherName: String? = null,
    val isFatherDeceased: Boolean? = null,
    val motherName: String? = null,
    val isMotherDeceased: Boolean? = null,
) {
    fun toGroomProfile(): GroomProfile {
        return GroomProfile(
            name = name,
            fatherName = fatherName,
            isFatherDeceased = isFatherDeceased,
            motherName = motherName,
            isMotherDeceased = isMotherDeceased,
        )
    }
}
