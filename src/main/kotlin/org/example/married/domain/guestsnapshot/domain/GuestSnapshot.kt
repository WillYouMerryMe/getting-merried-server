package org.example.married.domain.guestsnapshot.domain

import org.example.married.global.util.generateDocumentId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("guestSnapshots")
data class GuestSnapshot(
    @Id
    val id: String = generateDocumentId(),
    val imageUrls: List<String>,
    val cardId: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    var deletedAt: LocalDateTime? = null,
) {
}