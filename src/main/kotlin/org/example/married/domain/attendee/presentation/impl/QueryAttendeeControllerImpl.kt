package org.example.married.domain.attendee.presentation.impl

import org.example.married.domain.attendee.presentation.QueryAttendeeController
import org.example.married.domain.attendee.presentation.dto.request.GetAttendeesRequest
import org.example.married.domain.attendee.presentation.dto.response.GetAttendeeResponse
import org.example.married.domain.attendee.service.QueryAttendeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/attendees")
@RestController
class QueryAttendeeControllerImpl(
    private val queryAttendeeService: QueryAttendeeService,
): QueryAttendeeController {

    @GetMapping("/{id}")
    override fun getAttendeeList(
        @PathVariable id: String,
        @ModelAttribute request: GetAttendeesRequest,
    ): ResponseEntity<List<GetAttendeeResponse>> {
        val result = queryAttendeeService.getAttendeeList(id, request)
        return ResponseEntity.ok(result)
    }
}