package org.example.married.domain.guestsnapshot.presentation.dto.request

data class CreateGuestSnapshotRequest(
    val cardId: String,
    val urls: List<String>,
) {
}