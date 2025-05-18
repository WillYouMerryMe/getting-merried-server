package org.example.married.domain.user.domain

import org.example.married.domain.user.domain.type.Provider
import org.example.married.global.entity.BaseEntity
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
data class User(
    @Indexed(unique = true)
    val email: String,
    val nickname: String,
    val profileImg: String,
    val provider: Provider,
): BaseEntity() {
}
