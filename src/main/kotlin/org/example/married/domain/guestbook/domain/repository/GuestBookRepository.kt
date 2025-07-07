package org.example.married.domain.guestbook.domain.repository

import org.example.married.domain.guestbook.domain.GuestBook
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface GuestBookRepository: MongoRepository<GuestBook, String> {
    fun findAllByCardId(cardId: String): List<GuestBook>
}