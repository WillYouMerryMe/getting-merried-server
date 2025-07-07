package org.example.married.domain.attendee.presentation.impl

import org.example.married.domain.attendee.presentation.QueryAttendeeController
import org.example.married.domain.attendee.presentation.dto.request.GetAttendeesRequest
import org.example.married.domain.attendee.presentation.dto.response.GetAttendeeResponse
import org.example.married.domain.attendee.service.QueryAttendeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/attendees")
@RestController
class QueryAttendeeControllerImpl(
    private val queryAttendeeService: QueryAttendeeService,
): QueryAttendeeController {

    @GetMapping
    override fun getAttendeeList(
        @RequestBody request: GetAttendeesRequest,
    ): ResponseEntity<List<GetAttendeeResponse>> {
        val result = queryAttendeeService.getAttendeeList(request)
        return ResponseEntity.ok(result)
    }
}