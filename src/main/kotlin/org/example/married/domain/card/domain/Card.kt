package org.example.married.domain.card.domain

import org.example.married.domain.card.domain.component.*
import org.example.married.global.entity.BaseEntity
import org.springframework.data.mongodb.core.mapping.Document

@Document("cards")
data class Card(
    val title: String,
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
    val guestBook: GuestBook? = null,
    val guestSnapshots: GuestSnapshots? = null,
    val shareUrlStyle: ShareUrlStyle? = null,
    val componentOrders: List<CardComponentOrder>,
    val userId: Long,
): BaseEntity()
