package org.example.married.domain.card.presentation.dto.request

import org.example.married.domain.card.domain.component.*

data class CreateCardRequest(
    val title: String,
    val invitationSetting: InvitationSettingDto,
    val mainPageSetting: MainPageSettingDto,
    val invitationMessage: InvitationMessageDto? = null,
    val groomProfile: GroomProfileDto? = null,
    val brideProfile: BrideProfileDto? = null,
    val weddingInfo: WeddingInfoDto? = null,
    val photoGallery: PhotoGalleryDto? = null,
    val videoGallery: VideoGalleryDto? = null,
    val locationGuide: LocationGuideDto? = null,
    val accountInfo: AccountInfoDto? = null,
    val guestNotice: GuestNoticeDto? = null,
    val guestBook: GuestBookDto? = null,
    val guestSnapshots: GuestSnapshotsDto? = null,
    val shareUrlStyle: ShareUrlStyleDto? = null,
    val componentOrders: List<CardComponentOrder>,
) {
}
