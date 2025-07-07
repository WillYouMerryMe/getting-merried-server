package org.example.married.domain.card.presentation.impl

import org.example.married.domain.card.presentation.QueryCardController
import org.example.married.domain.card.presentation.dto.response.GetCardsResponse
import org.example.married.domain.card.presentation.dto.response.GetCardResponse
import org.example.married.domain.card.service.QueryCardService
import org.example.married.domain.user.domain.facade.UserFacade
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/cards")
@RestController
class QueryCardControllerImpl(
    private val queryCardService: QueryCardService,
): QueryCardController {

    @GetMapping("/{id}")
    override fun getById(
        @PathVariable id: String,
    ): ResponseEntity<GetCardResponse> {
        val result = queryCardService.getCardById(id)
        return ResponseEntity.ok(result)
    }

    @GetMapping("/list")
    override fun getCards(

    ): ResponseEntity<List<GetCardsResponse>> {
        val result = queryCardService.getCards(UserFacade.getCurrentUser())
        return ResponseEntity.ok(result)
    }
}