package org.example.married.domain.attendee.service

import org.example.married.domain.attendee.domain.Attendee
import org.example.married.domain.attendee.domain.repository.AttendeeRepository
import org.example.married.domain.attendee.presentation.dto.request.GetAccountInfoRequest
import org.example.married.domain.attendee.presentation.dto.response.GetAccountInfoResponse
import org.example.married.domain.card.domain.repository.CardRepository
import org.example.married.domain.card.domain.repository.findByIdOrNull
import org.example.married.global.annotation.CustomService

@CustomService
class CommandAttendeeService(
    private val attendeeRepository: AttendeeRepository,
    private val cardRepository: CardRepository,
) {

    fun getAccountInfo(
        request: GetAccountInfoRequest,
    ): GetAccountInfoResponse {
        attendeeRepository.existsByCardIdAndPhoneNumber(
            request.cardId, request.phoneNumber
        ).takeIf { !it }?.apply {
            val attendee = Attendee(
                name = request.name,
                phoneNumber = request.phoneNumber,
                hasSentGift = true,
                cardId = request.cardId,
            )

            attendeeRepository.save(attendee)
        }

        val card = cardRepository.findByIdOrNull(request.cardId)
        return GetAccountInfoResponse.from(card.accountInfo)
    }
}
