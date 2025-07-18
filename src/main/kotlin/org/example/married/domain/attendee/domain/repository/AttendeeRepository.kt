package org.example.married.domain.attendee.domain.repository

import org.example.married.domain.attendee.domain.Attendee
import org.example.married.domain.attendee.exception.AttendeeNotFoundException
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
interface AttendeeRepository: MongoRepository<Attendee, String> {
    fun findByCardIdAndPhoneNumber(cardId: String, phoneNumber: String): Attendee?

    fun findAllByCardId(cardId: String): List<Attendee>
}

fun AttendeeRepository.findByIdOrNull(attendeeId: String): Attendee {
    return findByIdOrNull(attendeeId)
        ?: throw AttendeeNotFoundException("Not found attendee = $attendeeId")
}