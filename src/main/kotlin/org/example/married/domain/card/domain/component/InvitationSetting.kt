package org.example.married.domain.card.domain.component

data class InvitationSetting(
    val pointColor: String,
    val font: FontDetail,
)

data class InvitationSettingDto(
    val pointColor: String,
    val font: FontDetailDto,
) {
    fun toInvitationSetting(): InvitationSetting {
        return InvitationSetting(
            pointColor = pointColor,
            font = font.toFontDetail(),
        )
    }
}
