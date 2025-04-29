package org.example.merried.global.feign.auth.naver

import org.example.merried.global.feign.auth.naver.response.NaverUserProfileResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "NaverInformationClient", url = "https://openapi.naver.com")
interface NaverUserClient {
    @GetMapping("/v1/nid/me")
    fun getUserProfile(
        @RequestHeader("Authorization") token: String,
    ): NaverUserProfileResponse
}