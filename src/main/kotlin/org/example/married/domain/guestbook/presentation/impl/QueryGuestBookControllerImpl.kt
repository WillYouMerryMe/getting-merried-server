package org.example.married.domain.guestbook.presentation.impl

import org.example.married.domain.guestbook.presentation.QueryGuestBookController
import org.example.married.domain.guestbook.presentation.dto.request.GetGuestBookRequest
import org.example.married.domain.guestbook.presentation.dto.response.GetGuestBookListResponse
import org.example.married.domain.guestbook.presentation.dto.response.GetGuestBookResponse
import org.example.married.domain.guestbook.service.QueryGuestBookService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/guestbooks")
@RestController
class QueryGuestBookControllerImpl(
    private val queryGuestBookService: QueryGuestBookService,
): QueryGuestBookController {

    @PostMapping
    override fun getGuestBooks(
        @RequestBody request: GetGuestBookRequest,
    ): ResponseEntity<List<GetGuestBookResponse>> {
        val request = queryGuestBookService.getGuestBooks(request)
        return ResponseEntity.ok(request)
    }

    @GetMapping("/{id}")
    override fun getGuestBookList(
        @PathVariable id: String
    ): ResponseEntity<List<GetGuestBookListResponse>> {
        val request = queryGuestBookService.getGuestBookList(id)
        return ResponseEntity.ok(request)
    }
}