package org.example.married.domain.attendee.presentation.dto.response

import org.example.married.domain.card.domain.component.AccountInfo
import org.example.married.domain.card.domain.component.BankInfo

data class GetAccountInfoResponse(
    val groom: BankInfo?,
    val bride: BankInfo?,
    val groomFather: BankInfo?,
    val groomMother: BankInfo?,
    val brideFather: BankInfo?,
    val brideMother: BankInfo?,
) {
    companion object {
        fun from(
            accountInfo: AccountInfo?,
        ): GetAccountInfoResponse {
            return GetAccountInfoResponse(
                groom = accountInfo?.groom,
                bride = accountInfo?.bride,
                groomFather = accountInfo?.groomFather,
                groomMother = accountInfo?.groomMother,
                brideFather = accountInfo?.brideFather,
                brideMother = accountInfo?.brideMother,
            )
        }
    }
}
