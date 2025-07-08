package org.example.married.domain.attendee.service

import org.example.married.domain.attendee.domain.repository.AttendeeRepository
import org.example.married.domain.attendee.presentation.dto.request.GetAttendeesRequest
import org.example.married.domain.attendee.presentation.dto.response.GetAttendeeResponse
import org.example.married.domain.attendee.presentation.dto.response.GetAttendeeResponse.Companion.GetAttendeeResponse
import org.example.married.global.annotation.CustomService

@CustomService(readOnly = true)
class QueryAttendeeService(
    private val attendeeRepository: AttendeeRepository,
) {

    fun getAttendeeList(
        id: String,
        request: GetAttendeesRequest,
    ): List<GetAttendeeResponse> {
        val attendees = attendeeRepository.findAllByCardId(id)

        val filtered = attendees
            .let { list ->
                var result = list
                request.isAttendee?.let { flag ->
                    result = result.filter { it.isAttending == flag }
                }
                request.hasSentGift?.let { flag ->
                    result = result.filter { it.hasSentGift == flag }
                }
                request.isEating?.let { flag ->
                    result = result.filter { it.mealPreference.isEating == flag }
                }
                result
            }

        return filtered.map { GetAttendeeResponse(it) }
    }
}