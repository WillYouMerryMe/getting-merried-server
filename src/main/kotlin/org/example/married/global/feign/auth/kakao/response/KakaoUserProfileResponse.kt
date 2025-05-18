package org.example.married.global.feign.auth.kakao.response

import org.example.married.global.feign.auth.dto.AuthProfile

data class KakaoUserProfileResponse(
    val kakao_account: KakaoAccount,
) {
    data class KakaoAccount(
        val profile: KakaoProfile,
    )

    data class KakaoProfile(
        val email: String,
        val nickname: String,
        val profile_image_url: String,
    )

    fun getAuthProfile(): AuthProfile {
        val profile = kakao_account.profile

        return AuthProfile(
            profile.email,
            profile.nickname,
            profile.profile_image_url,
        )
    }
}
