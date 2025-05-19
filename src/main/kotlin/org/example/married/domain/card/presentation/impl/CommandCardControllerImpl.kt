package org.example.married.domain.card.presentation.impl

import org.example.married.domain.card.presentation.CommandCardController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/cards")
@RestController
class CommandCardControllerImpl(

): CommandCardController {
    override fun createCard() {

    }
}