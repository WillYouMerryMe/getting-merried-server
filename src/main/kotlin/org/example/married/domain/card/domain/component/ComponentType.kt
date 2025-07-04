package org.example.married.domain.card.domain.component

import com.fasterxml.jackson.annotation.JsonValue

enum class ComponentType {
    INVITATION_MESSAGE,
    GROOM_BRIDE_PROFILE,
    WEDDING_DATE,
    PHOTO_GALLERY,
    VIDEO_GALLERY,
    LOCATION_GUIDE,
    ACCOUNT_INFO,
    GUEST_NOTICE,
    GUEST_BOOK,
    GUEST_SNAPSHOTS,
    SHARE_URL_STYLE;

    @JsonValue
    fun getUserType(): String {
        return name
    }
}

data class CardComponentOrder(
    val componentType: ComponentType,
    val order: Int
)
