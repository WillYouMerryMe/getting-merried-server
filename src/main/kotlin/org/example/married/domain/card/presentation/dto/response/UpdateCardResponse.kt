package org.example.married.domain.card.presentation.dto.response

import org.example.married.domain.card.domain.Card
import org.example.married.domain.card.domain.component.*

data class UpdateCardResponse(
    val id: String,
    val title: String,
    val templateId: String,
    val invitationSetting: InvitationSetting,
    val mainPageSetting: MainPageSetting,
    val invitationMessage: InvitationMessage? = null,
    val groomProfile: GroomProfile? = null,
    val brideProfile: BrideProfile? = null,
    val weddingInfo: WeddingInfo? = null,
    val photoGallery: PhotoGallery? = null,
    val videoGallery: VideoGallery? = null,
    val locationGuide: LocationGuide? = null,
    val accountInfo: AccountInfo? = null,
    val guestNotice: GuestNotice? = null,
    val guestBook: GuestBookInfo? = null,
    val guestSnapshots: GuestSnapshotInfo? = null,
    val shareUrlStyle: ShareUrlStyle? = null,
    val componentOrders: List<CardComponentOrder>,
) {
    companion object {
        fun of(
            card: Card,
        ): UpdateCardResponse {
            return UpdateCardResponse(
                id = card.id,
                title = card.title,
                templateId = card.templateId,
                invitationSetting = card.invitationSetting,
                mainPageSetting = card.mainPageSetting,
                invitationMessage = card.invitationMessage,
                groomProfile = card.groomProfile,
                brideProfile = card.brideProfile,
                weddingInfo = card.weddingInfo,
                photoGallery = card.photoGallery,
                videoGallery = card.videoGallery,
                locationGuide = card.locationGuide,
                accountInfo = card.accountInfo,
                guestNotice = card.guestNotice,
                guestBook = card.guestBookInfo,
                guestSnapshots = card.guestSnapshotInfo,
                shareUrlStyle = card.shareUrlStyle,
                componentOrders = card.componentOrders,
            )
        }
    }
}