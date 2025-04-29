package org.example.married.global.feign.auth.kakao

import org.example.married.global.feign.auth.kakao.response.KakaoUserProfileResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "KakaoUserClient", url = "https://kapi.kakao.com")
interface KakaoUserClient {
    @GetMapping("/v2/user/me")
    fun getUserProfile(
        @RequestHeader("Authorization") token: String,
    ): KakaoUserProfileResponse
}