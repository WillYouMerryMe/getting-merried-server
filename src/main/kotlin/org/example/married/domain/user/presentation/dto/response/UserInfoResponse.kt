package org.example.married.domain.user.presentation.dto.response

import org.example.married.domain.user.domain.User
import org.example.married.domain.user.domain.type.Provider

data class UserInfoResponse(
    val email: String,
    val nickname: String,
    val profileImg: String,
    val provider: Provider,
) {
    companion object {
        fun from(user: User): UserInfoResponse {
            return UserInfoResponse(
                email = user.email,
                nickname = user.nickname,
                profileImg = user.profileImg,
                provider = user.provider,
            )
        }
    }
}
