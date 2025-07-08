package org.example.married.domain.guestsnapshot.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.example.married.domain.guestbook.presentation.dto.response.GetGuestBookResponse
import org.example.married.domain.guestsnapshot.presentation.dto.request.GetGuestSnapshotRequest
import org.springframework.http.ResponseEntity

@Tag(name = "GuestSnapshot API")
interface QueryGuestSnapshotController {

    @Operation(
        summary = "스냅샷 조회 API 입니다.",
        description = "스냅샷의 정보를 보낼 시 내용을 확인할 수 있습니다.",
    )
    fun getGuestSnapshot(
        request: GetGuestSnapshotRequest,
    ): ResponseEntity<List<String>>
}