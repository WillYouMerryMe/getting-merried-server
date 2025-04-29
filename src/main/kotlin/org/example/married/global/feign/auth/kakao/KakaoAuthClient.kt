package org.example.married.global.feign.auth.kakao

import org.example.married.global.feign.auth.kakao.response.KakaoAuthResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "KakaoAuthClient", url = "https://kauth.kakao.com")
interface KakaoAuthClient {
    @GetMapping("/oauth/token?grant_type=authorization_code")
    fun getAccessToken(
        @RequestParam("client_id") clientId: String,
        @RequestParam("redirect_uri") redirectUri: String,
        @RequestParam("code") code: String,
    ): KakaoAuthResponse
}