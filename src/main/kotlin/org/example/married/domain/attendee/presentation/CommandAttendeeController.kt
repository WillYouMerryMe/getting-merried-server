package org.example.married.domain.attendee.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.example.married.domain.attendee.presentation.dto.request.CreateAttendeeRequest
import org.example.married.domain.attendee.presentation.dto.request.GetAccountInfoRequest
import org.example.married.domain.attendee.presentation.dto.request.GetAttendeeInfoRequest
import org.example.married.domain.attendee.presentation.dto.request.UpdateAttendeeRequest
import org.example.married.domain.attendee.presentation.dto.response.GetAccountInfoResponse
import org.springframework.http.ResponseEntity

@Tag(name = "Attendee API")
interface CommandAttendeeController {

    @Operation(
        summary = "청첩장의 참석자 추가 API 입니다.",
        description = "참석자의 정보를 받아 저장합니다.",
    )
    fun createAttendee(
        request: CreateAttendeeRequest,
    ): ResponseEntity<Void>

    @Operation(
        summary = "청첩장의 참석자 수정 API 입니다.",
        description = "참석자의 정보를 받아 수정합니다.",
    )
    fun updateAttendee(
        request: UpdateAttendeeRequest,
    ): ResponseEntity<Void>

    @Operation(
        summary = "청첩장의 계좌번호 조회 API 입니다. | accessToken X",
        description = "이름과 정보를 제공 시 청첩장의 계좌 번호를 반환합니다.",
    )
    fun viewAccount(
        request: GetAccountInfoRequest,
    ): ResponseEntity<GetAccountInfoResponse>

    @Operation(
        summary = "청첩장의 결혼식 참석 의사 API 입니다. | accessToken X",
        description = "결혼식 참석 의사 정보를 저장합니다.",
    )
    fun saveAttendeeInfo(
        request: GetAttendeeInfoRequest,
    ): ResponseEntity<Void>

    @Operation(
        summary = "청첩장의 결혼식 참석 의사 삭제 API 입니다.",
        description = "결혼식 참석 의사 정보를 삭제합니다.",
    )
    fun deleteAttendeeInfo(
        id: String,
    ): ResponseEntity<Void>
}