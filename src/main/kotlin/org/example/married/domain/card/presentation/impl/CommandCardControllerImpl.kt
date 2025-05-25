package org.example.married.domain.card.presentation.impl

import org.example.married.domain.card.presentation.CommandCardController
import org.example.married.domain.card.presentation.dto.request.CreateCardRequest
import org.example.married.domain.card.service.CommandCardService
import org.example.married.domain.user.domain.facade.UserFacade
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @DeleteMapping("/{id}")
    override fun deleteCard(
        @PathVariable id: String
    ): ResponseEntity<Void> {
        commandCardService.deleteCard(id, UserFacade.getCurrentUser())
        return ResponseEntity.noContent().build()
    }
}
