package org.example.married.global.feign.auth.dto

data class AuthProfile(
    val email: String,
    val nickname: String,
    val profileImg: String,
)