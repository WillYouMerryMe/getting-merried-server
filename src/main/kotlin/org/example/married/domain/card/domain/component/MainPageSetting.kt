package org.example.married.domain.card.domain.component

data class MainPageSetting(
    val picture: String,
    val lettering: String,
    val letteringColor: String,
)

data class MainPageSettingDto(
    val picture: String,
    val lettering: String,
    val letteringColor: String,
) {
    fun toMainPageSetting(): MainPageSetting {
        return MainPageSetting(
            picture = picture,
            lettering = lettering,
            letteringColor = letteringColor,
        )
    }
}
