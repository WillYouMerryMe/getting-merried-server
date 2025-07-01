package org.example.married.domain.user.domain

import org.example.married.domain.user.domain.type.Provider
import org.example.married.global.entity.BaseEntity
import org.example.married.global.util.generateDocumentId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document("users")
data class User(
    @Id
    val id: String = generateDocumentId(),
    @Indexed(unique = true)
    val email: String,
    val nickname: String,
    val profileImg: String,
    val provider: Provider,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    var deletedAt: LocalDateTime? = null,
) {
}
