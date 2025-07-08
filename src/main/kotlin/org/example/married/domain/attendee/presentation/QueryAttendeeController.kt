package org.example.married.domain.attendee.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.example.married.domain.attendee.presentation.dto.request.GetAttendeesRequest
import org.example.married.domain.attendee.presentation.dto.response.GetAttendeeResponse
import org.springframework.http.ResponseEntity

@Tag(name = "Attendee API")
interface QueryAttendeeController {

    @Operation(
        summary = "청첩장의 참석자 리스트 API 입니다. (필터링 가능)",
        description = "청첩장의 참석자 리스트를 반환합니다. 필터에 null을 추가할 시 모든 조건은 반환합니다.",
    )
    fun getAttendeeList(
        id: String,
        request: GetAttendeesRequest,
    ): ResponseEntity<List<GetAttendeeResponse>>
}