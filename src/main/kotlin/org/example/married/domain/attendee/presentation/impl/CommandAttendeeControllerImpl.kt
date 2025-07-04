package org.example.married.domain.attendee.presentation.impl

import org.example.married.domain.attendee.presentation.CommandAttendeeController
import org.example.married.domain.attendee.presentation.dto.request.GetAccountInfoRequest
import org.example.married.domain.attendee.presentation.dto.request.GetAttendeeInfoRequest
import org.example.married.domain.attendee.presentation.dto.response.GetAccountInfoResponse
import org.example.married.domain.attendee.service.CommandAttendeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/attendees")
@RestController
class CommandAttendeeControllerImpl(
    private val commandAttendeeService: CommandAttendeeService,
): CommandAttendeeController {

    @PostMapping("/account")
    override fun viewAccount(
        @RequestBody request: GetAccountInfoRequest,
    ): ResponseEntity<GetAccountInfoResponse> {
        val result = commandAttendeeService.getAccountInfo(request)
        return ResponseEntity.ok(result)
    }

    @PostMapping
    override fun saveAttendeeInfo(
        @RequestBody request: GetAttendeeInfoRequest,
    ): ResponseEntity<Void> {
        commandAttendeeService.saveAttendeeInfo(request)
        return ResponseEntity.noContent().build()
    }


}