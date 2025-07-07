package org.example.married.domain.guestsnapshot.domain.repository

import org.example.married.domain.guestsnapshot.domain.GuestSnapshot
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface GuestSnapshotRepository: MongoRepository<GuestSnapshot, String> {
    fun findAllByCardId(cardId: String): List<GuestSnapshot>
}