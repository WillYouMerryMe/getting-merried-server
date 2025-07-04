package org.example.married.domain.attendee.service

import org.example.married.domain.attendee.domain.Attendee
import org.example.married.domain.attendee.domain.repository.AttendeeRepository
import org.example.married.domain.attendee.exception.AttendeeAlreadyException
import org.example.married.domain.attendee.presentation.dto.request.CreateAttendeeRequest
import org.example.married.domain.attendee.presentation.dto.request.GetAccountInfoRequest
import org.example.married.domain.attendee.presentation.dto.request.GetAttendeeInfoRequest
import org.example.married.domain.attendee.presentation.dto.response.GetAccountInfoResponse
import org.example.married.domain.card.domain.repository.CardRepository
import org.example.married.domain.card.domain.repository.findByIdOrNull
import org.example.married.global.annotation.CustomService
import org.springframework.http.ResponseEntity

@CustomService
class CommandAttendeeService(
    private val attendeeRepository: AttendeeRepository,
    private val cardRepository: CardRepository,
) {

    fun createAttendee(
        request: CreateAttendeeRequest,
    ) {
        attendeeRepository.findByCardIdAndPhoneNumber(
            request.cardId, request.phoneNumber,
        )?.let { throw AttendeeAlreadyException() }

        val attendee = Attendee(
            name = request.name,
            phoneNumber = request.phoneNumber,
            isAttending = request.isAttending,
            hasSentGift = request.hasSentGift,
            isEating = request.isEating,
            cardId = request.cardId,
        )

        attendeeRepository.save(attendee)
    }

    fun getAccountInfo(
        request: GetAccountInfoRequest,
    ): GetAccountInfoResponse {
        val attendee = attendeeRepository.findByCardIdAndPhoneNumber(
            request.cardId, request.phoneNumber
        )?.updateAccountInfo() ?: Attendee(
            name = request.name,
            phoneNumber = request.phoneNumber,
            hasSentGift = true,
            cardId = request.cardId,
        )

        attendeeRepository.save(attendee)

        val card = cardRepository.findByIdOrNull(request.cardId)
        return GetAccountInfoResponse.from(card.accountInfo)
    }

    fun saveAttendeeInfo(
        request: GetAttendeeInfoRequest,
    ) {
        val attendee = attendeeRepository.findByCardIdAndPhoneNumber(
            request.cardId,
            request.phoneNumber,
        )?.updateAttendeeInfo(
            side = request.side,
            numberOfAttendees = request.numberOfAttendees,
            mealPreference = request.mealPreference,
        ) ?: Attendee(
            name = request.name,
            phoneNumber = request.phoneNumber,
            side = request.side,
            numberOfAttendees = request.numberOfAttendees,
            mealPreference = request.mealPreference,
            cardId = request.cardId,
        )

        attendeeRepository.save(attendee)
    }
}
