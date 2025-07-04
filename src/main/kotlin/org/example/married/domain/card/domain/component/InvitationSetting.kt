package org.example.married.domain.card.domain.component

data class InvitationSetting(
    val pointColor: String,
    val font: String,
)

data class InvitationSettingDto(
    val pointColor: String,
    val font: String,
) {
    fun toInvitationSetting(): InvitationSetting {
        return InvitationSetting(
            pointColor = pointColor,
            font = font,
        )
    }
}
