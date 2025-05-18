package org.example.married.global.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("auth")
class AuthProperties(
        val kakao: Kakao,
        val naver: Naver,
) {
    data class Kakao(
        val baseUrl: String,
        val clientId: String,
        val javascriptId: String,
        val redirectUrl: String,
    )

    data class Naver(
        val baseUrl: String,
        val clientId: String,
        val secretId: String,
        val redirectUrl: String,
        val state: String,
    )
}