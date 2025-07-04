package org.example.married.domain.attendee.service

import org.example.married.domain.attendee.domain.repository.AttendeeRepository
import org.example.married.domain.attendee.presentation.dto.response.GetAttendeeResponse
import org.example.married.domain.attendee.presentation.dto.response.GetAttendeeResponse.Companion.GetAttendeeResponse
import org.example.married.global.annotation.CustomService

@CustomService(readOnly = true)
class QueryAttendeeService(
    private val attendeeRepository: AttendeeRepository,
) {

    fun getAttendeeList(
        cardId: String,
    ): List<GetAttendeeResponse> {
        return attendeeRepository.findAllByCardId(cardId)
            .map { GetAttendeeResponse(it) }
    }
}