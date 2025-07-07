package org.example.married.domain.guestsnapshot.service

import org.example.married.domain.card.domain.repository.CardRepository
import org.example.married.domain.card.domain.repository.findByIdOrNull
import org.example.married.domain.guestbook.exception.GuestBookNotFoundException
import org.example.married.domain.guestbook.presentation.dto.request.GetGuestBookRequest
import org.example.married.domain.guestbook.presentation.dto.response.GetGuestBookResponse
import org.example.married.domain.guestsnapshot.domain.repository.GuestSnapshotRepository
import org.example.married.domain.guestsnapshot.presentation.dto.request.GetGuestSnapshotRequest
import org.example.married.global.annotation.CustomService

@CustomService(readOnly = true)
class QueryGuestSnapshotService(
    private val guestSnapshotRepository: GuestSnapshotRepository,
    private val cardRepository: CardRepository,
) {

    fun getGuestSnapshots(
        request: GetGuestSnapshotRequest,
    ): List<String> {
        val card = cardRepository.findByIdOrNull(request.cardId)

        if (card.guestSnapshotInfo?.masterPassword == request.password) {
            val results: List<String> = guestSnapshotRepository
                .findAllByCardId(request.cardId)
                .flatMap { snapshot -> snapshot.imageUrls }

            return results
        }

        throw GuestBookNotFoundException()
    }
}