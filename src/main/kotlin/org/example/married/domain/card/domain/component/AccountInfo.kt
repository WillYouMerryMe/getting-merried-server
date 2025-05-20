package org.example.married.domain.card.domain.component

data class AccountInfo(
    val title: String,
    val content: String,
    val groom: BankInfo? = null,
    val bride: BankInfo? = null,
    val groomFather: BankInfo? = null,
    val groomMother: BankInfo? = null,
    val brideFather: BankInfo? = null,
    val brideMother: BankInfo? = null,
)

data class BankInfo(
    val bankName: String,
    val accountNumber: String,
    val accountHolderName: String,
)

data class AccountInfoDto(
    val title: String,
    val content: String,
    val groom: BankInfoDto? = null,
    val bride: BankInfoDto? = null,
    val groomFather: BankInfoDto? = null,
    val groomMother: BankInfoDto? = null,
    val brideFather: BankInfoDto? = null,
    val brideMother: BankInfoDto? = null,
) {
    fun toAccountInfo(): AccountInfo {
        return AccountInfo(
            title = title,
            content = content,
            groom = groom?.toBankInfo(),
            bride = bride?.toBankInfo(),
            groomFather = groomFather?.toBankInfo(),
            groomMother = groomMother?.toBankInfo(),
            brideFather = brideFather?.toBankInfo(),
            brideMother = brideMother?.toBankInfo(),
        )
    }
}

data class BankInfoDto(
    val bankName: String,
    val accountNumber: String,
    val accountHolderName: String,
) {
    fun toBankInfo(): BankInfo {
        return BankInfo(
            bankName = bankName,
            accountNumber = accountNumber,
            accountHolderName = accountHolderName,
        )
    }
}
