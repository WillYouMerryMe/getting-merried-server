package org.example.married.domain.card.domain

import org.example.married.domain.card.domain.component.*
import org.example.married.global.entity.BaseEntity
import org.springframework.data.mongodb.core.mapping.Document

@Document("cards")
data class Card(
    val title: String,                                  // 청접장 명
    val invitationSetting: InvitationSetting,           // 청접장 전체 설정
    val mainPageSetting: MainPageSetting,               // 메인 화면 설정
    val invitationMessage: InvitationMessage? = null,   // 초대 글귀 - 순서 변경 요소
    val groomProfile: GroomProfile? = null,             // 신랑측 소개 - 순서 변경 요소
    val brideProfile: BrideProfile? = null,             // 신부측 소개 - 순서 변경 요소
    val weddingInfo: WeddingInfo? = null,               // 예식 정보 - 순서 변경 요소ㅌ
    val photoGallery: PhotoGallery? = null,             // 갤러리 - 순서 변경 요소
    val videoGallery: VideoGallery? = null,             // 영상 - 순서 변경 요소
    val locationGuide: LocationGuide? = null,           // 오시는 길 - 순서 변경 요소
    val accountInfo: AccountInfo? = null,               // 계좌번호 - 순서 변경 요소
    val guestNotice: GuestNotice? = null,               // 안내사항 - 순서 변경 요소
    val guestBook: GuestBook? = null,                   // 방명록 - 순서 변경 요소
    val guestSnapshots: GuestSnapshots? = null,         // 게스트 스냅 - 순서 변경 요소
    val shareUrlStyle: ShareUrlStyle? = null,           // URL 공유 스타일 설정 - 순서 변경 요소
    val componentOrders: List<CardComponentOrder>,
    val userId: String,
): BaseEntity()
