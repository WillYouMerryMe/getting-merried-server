package org.example.married.domain.card.domain.component

data class GuestSnapshots(
    val title: String? = null,
    val masterPassword: String,
)

data class GuestSnapshotsDto(
    val title: String? = null,
    val masterPassword: String,
) {
    fun toGuestSnapshots(): GuestSnapshots {
        return GuestSnapshots(
            title = title,
            masterPassword = masterPassword,
        )
    }
}
