package org.example.married.domain.user.service

import org.example.married.domain.user.domain.User
import org.example.married.domain.user.presentation.dto.response.UserInfoResponse
import org.example.married.global.annotation.CustomService

@CustomService(readOnly = true)
class QueryUserService(
) {

    fun getUserInfo(
        user: User
    ): UserInfoResponse {
        return UserInfoResponse.from(user)
    }
}