package org.example.married.domain.card.domain

import org.example.married.domain.card.domain.component.AccountInfo
import org.example.married.domain.card.domain.component.BrideProfile
import org.example.married.domain.card.domain.component.CardComponentOrder
import org.example.married.domain.card.domain.component.GroomProfile
import org.example.married.domain.card.domain.component.GuestBook
import org.example.married.domain.card.domain.component.GuestNotice
import org.example.married.domain.card.domain.component.GuestSnapshots
import org.example.married.domain.card.domain.component.InvitationMessage
import org.example.married.domain.card.domain.component.InvitationSetting
import org.example.married.domain.card.domain.component.LocationGuide
import org.example.married.domain.card.domain.component.MainPageSetting
import org.example.married.domain.card.domain.component.PhotoGallery
import org.example.married.domain.card.domain.component.ShareUrlStyle
import org.example.married.domain.card.domain.component.VideoGallery
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
    val weddingDate: String? = null,
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
