package org.example.married.global.feign.auth.kakao.response

import org.example.married.global.feign.auth.dto.AuthProfile

data class KakaoUserProfileResponse(
    val kakao_account: KakaoAccount,
) {
    data class KakaoAccount(
        val profile: KakaoProfile,
        val email: String,
    )

    data class KakaoProfile(
        val nickname: String,
        val profile_image_url: String,
    )

    fun getAuthProfile(): AuthProfile {
        val profile = kakao_account.profile

        return AuthProfile(
            kakao_account.email,
            profile.nickname,
            profile.profile_image_url,
        )
    }
}
