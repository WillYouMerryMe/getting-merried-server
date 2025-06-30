package org.example.married.domain.card.domain.component

data class MainPageSetting(
    val picture: String,
    val font: FontDetail,
    val lettering: List<String>,
    val letteringColor: String,
)

data class MainPageSettingDto(
    val picture: String,
    val font: FontDetailDto,
    val lettering: List<String>,
    val letteringColor: String,
) {
    fun toMainPageSetting(): MainPageSetting {
        return MainPageSetting(
            picture = picture,
            font = font.toFontDetail(),
            lettering = lettering,
            letteringColor = letteringColor,
        )
    }
}
