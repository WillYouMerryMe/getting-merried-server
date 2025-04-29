package org.example.merried.global.feign.auth.naver

import org.example.merried.global.feign.auth.naver.response.NaverAuthResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "NaverAuthClient", url = "https://nid.naver.com")
interface NaverAuthClient {
    @GetMapping("/oauth2.0/token?grant_type=authorization_code")
    fun getAccessToken(
        @RequestParam("client_id") clientId: String,
        @RequestParam("client_secret") clientSecret: String,
        @RequestParam("code") code: String,
        @RequestParam("redirect_uri") redirectUri: String,
        @RequestParam("state") state: String,
    ): NaverAuthResponse
}