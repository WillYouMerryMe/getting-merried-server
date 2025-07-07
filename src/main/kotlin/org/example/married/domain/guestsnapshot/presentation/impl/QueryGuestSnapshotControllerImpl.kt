package org.example.married.domain.guestsnapshot.presentation.impl

import org.example.married.domain.guestsnapshot.presentation.QueryGuestSnapshotController
import org.example.married.domain.guestsnapshot.presentation.dto.request.GetGuestSnapshotRequest
import org.example.married.domain.guestsnapshot.service.QueryGuestSnapshotService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/guestSnapshots")
@RestController
class QueryGuestSnapshotControllerImpl(
    private val queryGuestSnapshotService: QueryGuestSnapshotService,
): QueryGuestSnapshotController {

    @PostMapping
    override fun getGuestSnapshot(
        @RequestBody request: GetGuestSnapshotRequest,
    ): ResponseEntity<List<String>> {
        val request = queryGuestSnapshotService.getGuestSnapshots(request)
        return ResponseEntity.ok(request)
    }
}