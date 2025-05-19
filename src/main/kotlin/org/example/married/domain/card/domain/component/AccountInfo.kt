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
