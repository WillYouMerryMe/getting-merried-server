package org.example.married.domain.card.domain.component

data class MainPageSetting(
    val picture: String,
    val font: String,
    val lettering: List<String>,
    val letteringColor: String,
)

data class MainPageSettingDto(
    val picture: String,
    val font: String,
    val lettering: List<String>,
    val letteringColor: String,
) {
    fun toMainPageSetting(): MainPageSetting {
        return MainPageSetting(
            picture = picture,
            font = font,
            lettering = lettering,
            letteringColor = letteringColor,
        )
    }
}
