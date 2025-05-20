package org.example.married.domain.card.domain.component

data class InvitationMessage(
    val title: String,
    val content: String,
)

data class InvitationMessageDto(
    val title: String,
    val content: String,
) {
    fun toInvitationMessage(): InvitationMessage {
        return InvitationMessage(
            title = title,
            content = content,
        )
    }
}
