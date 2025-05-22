package org.example.married.domain.card.presentation.impl

import org.example.married.domain.card.presentation.CommandCardController
import org.example.married.domain.card.presentation.dto.request.CreateCardRequest
import org.example.married.domain.card.service.CommandCardService
import org.example.married.domain.user.domain.facade.UserFacade
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/cards")
@RestController
class CommandCardControllerImpl(
    private val commandCardService: CommandCardService,
): CommandCardController {

    @PostMapping
    override fun createCard(
        @RequestBody request: CreateCardRequest,
    ): ResponseEntity<String> {
        val result = commandCardService.createCard(request, UserFacade.getCurrentUser())
        return ResponseEntity.ok(result)
    }
}
