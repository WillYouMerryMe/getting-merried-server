package org.example.married.global.feign.auth.naver.response

data class NaverUserProfileResponse(
    val response: NaverProfile,
) {
    data class NaverProfile(
        val email: String,
        val nickname: String,
        val profile_image: String,
    )
}
