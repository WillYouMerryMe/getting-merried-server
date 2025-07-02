package org.example.married.domain.user.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.example.married.domain.user.presentation.dto.response.UserInfoResponse
import org.springframework.http.ResponseEntity

@Tag(name = "User API")
interface QueryUserController {

    @Operation(
        summary = "유저 정보 조회 API 입니다.",
        description = "유저 정보를 가진 token을 포함하여 요청을 보낼 시 유저 정보를 반환합니다.",
    )
    fun getUserInfo(
    ): ResponseEntity<UserInfoResponse>
}