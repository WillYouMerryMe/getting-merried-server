package org.example.married.domain.card.presentation

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.RequestBody

@Tag(name = "Card API")
interface CommandCardController {
    fun createCard(
        @RequestBody
    )
}