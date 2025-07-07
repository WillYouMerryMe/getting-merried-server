package org.example.married.domain.guestsnapshot.service

import org.example.married.domain.card.domain.repository.CardRepository
import org.example.married.domain.card.domain.repository.findByIdOrNull
import org.example.married.domain.guestsnapshot.domain.GuestSnapshot
import org.example.married.domain.guestsnapshot.domain.repository.GuestSnapshotRepository
import org.example.married.domain.guestsnapshot.exception.GuestSnapshotNotFoundException
import org.example.married.domain.guestsnapshot.presentation.dto.request.CreateGuestSnapshotRequest
import org.example.married.global.annotation.CustomService

@CustomService
class CommandGuestSnapshotService(
    private val guestSnapshotRepository: GuestSnapshotRepository,
    private val cardRepository: CardRepository,
) {

    fun createGuestSnapshot(
        request: CreateGuestSnapshotRequest,
    ) {
        val card = cardRepository.findByIdOrNull(request.cardId)

        card.guestSnapshotInfo
            ?: throw GuestSnapshotNotFoundException()

        val guestSnapshot = GuestSnapshot(
            imageUrls = request.urls,
            cardId = request.cardId,
        )

        guestSnapshotRepository.save(guestSnapshot)
    }
}