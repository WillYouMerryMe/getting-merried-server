package org.example.merried.domain.user.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import org.example.merried.global.entity.BaseEntity

@Entity
data class User(
    @Column(unique = true)
    val email: String,
    val username: String,
): BaseEntity() {
}