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
            title = request.title,
            templateId = request.templateId,
            invitationSetting = request.invitationSetting.toInvitationSetting(),
            mainPageSetting = request.mainPageSetting.toMainPageSetting(),
            invitationMessage = request.invitationMessage?.toInvitationMessage(),
            groomProfile = request.groomProfile?.toGroomProfile(),
            brideProfile = request.brideProfile?.toBrideProfile(),
            weddingInfo = request.weddingInfo?.toWeddingInfo(),
            photoGallery = request.photoGallery?.toPhotoGallery(),
            videoGallery = request.videoGallery?.toVideoGallery(),
            locationGuide = request.locationGuide?.toLocationGuide(),
            accountInfo = request.accountInfo?.toAccountInfo(),
            guestNotice = request.guestNotice?.toGuestNotice(),
            guestBook = request.guestBook?.toGuestBook(),
            guestSnapshots = request.guestSnapshots?.toGuestSnapshots(),
            shareUrlStyle = request.shareUrlStyle?.toShareUrlStyle(),
            componentOrders = request.componentOrders,
            userId = user.id,
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
