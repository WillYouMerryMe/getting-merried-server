package org.example.married.domain.card.domain.component

data class GuestSnapshotInfo(
    val title: String? = null,
    val masterPassword: String,
)

data class GuestSnapshotsDto(
    val title: String? = null,
    val masterPassword: String,
) {
    fun toGuestSnapshots(): GuestSnapshotInfo {
        return GuestSnapshotInfo(
            title = title,
            masterPassword = masterPassword,
        )
    }
}
