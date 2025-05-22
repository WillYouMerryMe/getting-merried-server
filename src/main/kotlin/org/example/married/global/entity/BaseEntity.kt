package org.example.married.global.entity

import org.example.married.global.util.generateDocumentId
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

abstract class BaseEntity {
    @Id
    val id: String = generateDocumentId()

    @CreatedDate
    @Field("created_at")
    lateinit var createdAt: LocalDateTime

    @LastModifiedDate
    @Field("updated_at")
    lateinit var updatedAt: LocalDateTime
}
