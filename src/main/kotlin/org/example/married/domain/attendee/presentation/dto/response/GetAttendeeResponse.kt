package org.example.married.domain.attendee.presentation.dto.response

import org.example.married.domain.attendee.domain.Attendee
import org.example.married.domain.attendee.domain.type.Side

data class GetAttendeeResponse(
    val id: String,
    val name: String,
    val side: Side?,
    val isAttending: Boolean,
    val hasSentGift: Boolean,
    val isEating: Boolean,
    val numberOfAttendees: Int,
) {
    companion object {
        fun GetAttendeeResponse(
            attendee: Attendee,
        ): GetAttendeeResponse {
            return GetAttendeeResponse(
                id = attendee.id,
                name = attendee.name,
                side = attendee.side,
                isAttending = attendee.isAttending,
                hasSentGift = attendee.hasSentGift,
                isEating = attendee.isEating,
                numberOfAttendees = attendee.numberOfAttendees,
            )
        }
    }
}
