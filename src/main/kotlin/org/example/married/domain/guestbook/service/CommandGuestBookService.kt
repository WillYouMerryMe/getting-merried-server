package org.example.married.domain.guestbook.service

import org.example.married.domain.card.domain.repository.CardRepository
import org.example.married.domain.card.domain.repository.findByIdOrNull
import org.example.married.domain.guestbook.domain.GuestBook
import org.example.married.domain.guestbook.domain.repository.GuestBookRepository
import org.example.married.domain.guestbook.exception.GuestBookNotFoundException
import org.example.married.domain.guestbook.presentation.dto.request.CreateGuestBookRequest
import org.example.married.global.annotation.CustomService

@CustomService
class CommandGuestBookService(
    private val guestBookRepository: GuestBookRepository,
    private val cardRepository: CardRepository,
) {

    fun createGuestBook(
        request: CreateGuestBookRequest,
    ) {
        val card = cardRepository.findByIdOrNull(request.cardId)

        card.guestBookInfo
            ?: throw GuestBookNotFoundException()

        val guestBook = GuestBook(
            name = request.name,
            content = request.content,
            cardId = request.cardId,
        )

        guestBookRepository.save(guestBook)
    }
}