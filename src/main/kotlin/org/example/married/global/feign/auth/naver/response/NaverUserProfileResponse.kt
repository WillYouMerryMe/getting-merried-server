package org.example.married.global.feign.auth.naver.response

import org.example.married.global.feign.auth.dto.AuthProfile

data class NaverUserProfileResponse(
    val response: NaverProfile,
) {
    data class NaverProfile(
        val email: String,
        val name: String,
        val profile_image: String,
    )

    fun getAuthProfile(): AuthProfile {
        return AuthProfile(
            response.email,
            response.name,
            response.profile_image,
        )
    }
}
