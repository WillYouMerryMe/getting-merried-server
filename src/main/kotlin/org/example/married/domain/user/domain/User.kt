package org.example.married.domain.user.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import org.example.married.domain.user.domain.type.Provider
import org.example.married.global.entity.BaseEntity

@Entity
data class User(
    @Column(unique = true)
    val email: String,
    val nickname: String,

    @Column(name = "profile_img")
    val profileImg: String,

    @Enumerated(EnumType.STRING)
    val provider: Provider,
): BaseEntity() {
}