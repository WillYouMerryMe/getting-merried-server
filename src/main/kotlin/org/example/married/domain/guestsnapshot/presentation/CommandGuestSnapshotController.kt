package org.example.married.domain.guestsnapshot.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.example.married.domain.guestsnapshot.presentation.dto.request.CreateGuestSnapshotRequest
import org.springframework.http.ResponseEntity

@Tag(name = "GuestSnapshot API")
interface CommandGuestSnapshotController {

    @Operation(
        summary = "스냅샷 등록 API 입니다. | accessToken X",
        description = "이미지 링크를 보낼시 스냅샷을 등록합니다.",
    )
    fun createGuestSnapshot(
        request: CreateGuestSnapshotRequest,
    ): ResponseEntity<Void>
}