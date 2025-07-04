package org.example.married.domain.attendee.domain.repository

import org.example.married.domain.attendee.domain.Attendee
import org.example.married.domain.attendee.exception.AttendeeNotFoundException
import org.example.married.domain.card.domain.Card
import org.example.married.domain.card.domain.repository.CardRepository
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
interface AttendeeRepository: MongoRepository<Attendee, String> {
    fun existsByCardIdAndPhoneNumber(cardId: String, phoneNumber: String): Boolean
}

fun CardRepository.findByIdOrNull(attendeeId: String): Card {
    return findByIdOrNull(attendeeId)
        ?: throw AttendeeNotFoundException("Not found attendee = $attendeeId")
}