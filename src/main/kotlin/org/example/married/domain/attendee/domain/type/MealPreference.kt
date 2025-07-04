package org.example.married.domain.attendee.domain.type

enum class MealPreference(
    val isEating: Boolean,
) {
    PLANNED(true),
    SKIP(false),
    UNDECIDED(false),
}