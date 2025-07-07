package org.example.married.domain.attendee.presentation.impl

import org.example.married.domain.attendee.presentation.CommandAttendeeController
import org.example.married.domain.attendee.presentation.dto.request.CreateAttendeeRequest
import org.example.married.domain.attendee.presentation.dto.request.GetAccountInfoRequest
import org.example.married.domain.attendee.presentation.dto.request.GetAttendeeInfoRequest
import org.example.married.domain.attendee.presentation.dto.request.UpdateAttendeeRequest
import org.example.married.domain.attendee.presentation.dto.response.GetAccountInfoResponse
import org.example.married.domain.attendee.service.CommandAttendeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
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

    @PostMapping
    override fun createAttendee(
        request: CreateAttendeeRequest,
    ): ResponseEntity<Void> {
        commandAttendeeService.createAttendee(request)
        return ResponseEntity.noContent().build()
    }

    @PatchMapping
    override fun updateAttendee(
        request: UpdateAttendeeRequest
    ): ResponseEntity<Void> {
        commandAttendeeService.updateAttendee(request)
        return ResponseEntity.noContent().build()
    }

    @PostMapping("/account")
    override fun viewAccount(
        @RequestBody request: GetAccountInfoRequest,
    ): ResponseEntity<GetAccountInfoResponse> {
        val result = commandAttendeeService.getAccountInfo(request)
        return ResponseEntity.ok(result)
    }

    @PostMapping("/intention")
    override fun saveAttendeeInfo(
        @RequestBody request: GetAttendeeInfoRequest,
    ): ResponseEntity<Void> {
        commandAttendeeService.saveAttendeeInfo(request)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{id}")
    override fun deleteAttendeeInfo(
        @PathVariable id: String
    ): ResponseEntity<Void> {
        commandAttendeeService.deleteAttendee(id)
        return ResponseEntity.noContent().build()
    }
}