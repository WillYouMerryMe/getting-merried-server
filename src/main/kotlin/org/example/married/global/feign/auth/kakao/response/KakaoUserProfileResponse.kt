package org.example.married.global.feign.auth.kakao.response

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
}
