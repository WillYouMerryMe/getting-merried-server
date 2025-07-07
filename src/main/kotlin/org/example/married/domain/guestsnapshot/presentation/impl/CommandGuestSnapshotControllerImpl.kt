package org.example.married.domain.guestsnapshot.presentation.impl

import org.example.married.domain.guestsnapshot.presentation.CommandGuestSnapshotController
import org.example.married.domain.guestsnapshot.presentation.dto.request.CreateGuestSnapshotRequest
import org.example.married.domain.guestsnapshot.service.CommandGuestSnapshotService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/guestSnapshots")
@RestController
class CommandGuestSnapshotControllerImpl(
    private val commandGuestSnapshotService: CommandGuestSnapshotService,
): CommandGuestSnapshotController {

    @PostMapping("/create")
    override fun createGuestSnapshot(
        @RequestBody request: CreateGuestSnapshotRequest,
    ): ResponseEntity<Void> {
        commandGuestSnapshotService.createGuestSnapshot(request)
        return ResponseEntity.noContent().build()
    }
}