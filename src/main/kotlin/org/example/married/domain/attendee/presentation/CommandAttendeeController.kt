package org.example.married.domain.attendee.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.example.married.domain.attendee.presentation.dto.request.GetAccountInfoRequest
import org.example.married.domain.attendee.presentation.dto.response.GetAccountInfoResponse
import org.springframework.http.ResponseEntity

@Tag(name = "Attendee API")
interface CommandAttendeeController {

    @Operation(
        summary = "청첩장의 계좌번호 조회 API 입니다.",
        description = "이름과 정보를 제공 시 청첩장의 계좌 번호를 반환합니다.",
    )
    fun viewAccount(
        request: GetAccountInfoRequest,
    ): ResponseEntity<GetAccountInfoResponse>
}