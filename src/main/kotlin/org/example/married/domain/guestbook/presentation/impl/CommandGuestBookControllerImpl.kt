package org.example.married.domain.guestbook.presentation.impl

import org.example.married.domain.guestbook.presentation.CommandGuestBookController
import org.example.married.domain.guestbook.presentation.dto.request.CreateGuestBookRequest
import org.example.married.domain.guestbook.service.CommandGuestBookService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/guestbooks")
@RestController
class CommandGuestBookControllerImpl(
    private val commandGuestBookService: CommandGuestBookService,
): CommandGuestBookController {

    @PostMapping("/create")
    override fun createGuestBook(
        @RequestBody request: CreateGuestBookRequest,
    ): ResponseEntity<Void> {
        commandGuestBookService.createGuestBook(request)
        return ResponseEntity.noContent().build()
    }
}