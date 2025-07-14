package org.example.married.domain.auth.facade

import org.example.married.domain.user.domain.type.Provider
import org.example.married.global.annotation.Facade
import org.example.married.global.config.properties.AuthProperties
import org.example.married.global.feign.auth.dto.AuthProfile
import org.example.married.global.feign.auth.kakao.KakaoAuthClient
import org.example.married.global.feign.auth.kakao.KakaoUserClient
import org.example.married.global.feign.auth.naver.NaverAuthClient
import org.example.married.global.feign.auth.naver.NaverUserClient

@Facade
class AuthFacade(
    private val kakaoAuthClient: KakaoAuthClient,
    private val kakaoUserClient: KakaoUserClient,
    private val authProperties: AuthProperties,
    private val naverAuthClient: NaverAuthClient,
    private val naverUserClient: NaverUserClient,
) {
    fun getUserInfo(code: String, provider: Provider, redirectUri: String): AuthProfile {
        when (provider) {
            Provider.NAVER -> {
                val accessToken = naverAuthClient.getAccessToken(
                    authProperties.naver.clientId,
                    authProperties.naver.secretId,
                    code,
                    redirectUri,
                    authProperties.naver.state,
                ).access_token

                val result = naverUserClient.getUserProfile("Bearer $accessToken")

                return result.getAuthProfile()
            }

            Provider.KAKAO -> {
                val accessToken = kakaoAuthClient.getAccessToken(
                    authProperties.kakao.clientId,
                    redirectUri,
                    code,
                ).access_token

                val result = kakaoUserClient.getUserProfile("Bearer $accessToken")

                return result.getAuthProfile()
            }
        }
    }
}