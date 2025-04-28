package org.example.merried.domain.auth.domain

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive

@RedisHash(value = "refresh_token")
data class RefreshToken(
    @Id
    val token: String,
    val email: String,

    @TimeToLive
    val expiration: Long,
)
