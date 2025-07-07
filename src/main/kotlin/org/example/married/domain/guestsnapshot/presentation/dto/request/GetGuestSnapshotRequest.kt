package org.example.married.domain.guestsnapshot.presentation.dto.request

data class GetGuestSnapshotRequest(
    val cardId: String,
    val password: String,
) {
}