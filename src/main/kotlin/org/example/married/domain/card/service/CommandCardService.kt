package org.example.married.domain.card.service

import org.example.married.domain.card.domain.Card
import org.example.married.domain.card.domain.repository.CardRepository
import org.example.married.domain.card.exception.CardNotFoundException
import org.example.married.domain.card.presentation.dto.request.CreateCardRequest
import org.example.married.domain.card.presentation.dto.request.UpdateCardRequest
import org.example.married.domain.card.presentation.dto.response.CreateCardResponse
import org.example.married.domain.card.presentation.dto.response.GetCardResponse
import org.example.married.domain.card.presentation.dto.response.UpdateCardResponse
import org.example.married.domain.user.domain.User
import org.example.married.global.annotation.CustomService

@CustomService
class CommandCardService(
    private val cardRepository: CardRepository,
) {
    fun createCard(
        request: CreateCardRequest,
        user: User,
    ): CreateCardResponse {
        val card = Card(
            request.title,
            request.invitationSetting.toInvitationSetting(),
            request.mainPageSetting.toMainPageSetting(),
            request.invitationMessage?.toInvitationMessage(),
            request.groomProfile?.toGroomProfile(),
            request.brideProfile?.toBrideProfile(),
            request.weddingInfo?.toWeddingInfo(),
            request.photoGallery?.toPhotoGallery(),
            request.videoGallery?.toVideoGallery(),
            request.locationGuide?.toLocationGuide(),
            request.accountInfo?.toAccountInfo(),
            request.guestNotice?.toGuestNotice(),
            request.guestBook?.toGuestBook(),
            request.guestSnapshots?.toGuestSnapshots(),
            request.shareUrlStyle?.toShareUrlStyle(),
            request.componentOrders,
            user.id,
        )

        cardRepository.save(card)
        return CreateCardResponse.of(card)
    }

    fun updateCard(
        request: UpdateCardRequest,
        user: User,
    ): UpdateCardResponse {
        val card = (cardRepository.findByIdAndUserId(request.id, user.id)
            ?: throw CardNotFoundException())

        val updateCard = card.update(request)
        cardRepository.save(updateCard)

        return UpdateCardResponse.of(updateCard)
    }

    fun deleteCard(
        id: String,
        user: User,
    ) {
        val card = cardRepository.findByIdAndUserId(id, user.id)
            ?: throw CardNotFoundException()
        cardRepository.delete(card)
    }
}
