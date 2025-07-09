package org.example.married.domain.guestbook.service

import org.example.married.domain.card.domain.repository.CardRepository
import org.example.married.domain.card.domain.repository.findByIdOrNull
import org.example.married.domain.guestbook.domain.repository.GuestBookRepository
import org.example.married.domain.guestbook.exception.GuestBookNotFoundException
import org.example.married.domain.guestbook.presentation.dto.request.GetGuestBookRequest
import org.example.married.domain.guestbook.presentation.dto.response.GetGuestBookListResponse
import org.example.married.domain.guestbook.presentation.dto.response.GetGuestBookResponse
import org.example.married.global.annotation.CustomService

@CustomService(readOnly = true)
class QueryGuestBookService(
    private val guestBookRepository: GuestBookRepository,
    private val cardRepository: CardRepository,
) {

    fun getGuestBooks(
        request: GetGuestBookRequest,
    ): List<GetGuestBookResponse> {
        val card = cardRepository.findByIdOrNull(request.cardId)

        if (card.guestBookInfo?.masterPassword == request.password) {
            return guestBookRepository.findAllByCardId(request.cardId)
                .map { GetGuestBookResponse.from(it) }
        }

        throw GuestBookNotFoundException()
    }

    fun getGuestBookList(
        id: String,
    ): List<GetGuestBookListResponse> {
        val card = cardRepository.findByIdOrNull(id)

        card.guestBookInfo?.let {
            return guestBookRepository.findAllByCardId(id)
                .map { GetGuestBookListResponse.from(it) }
        }

        throw GuestBookNotFoundException()
    }
}