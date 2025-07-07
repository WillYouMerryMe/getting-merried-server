package org.example.married.domain.guestsnapshot.exception
import org.example.married.global.error.exception.BusinessException
import org.example.married.global.error.exception.ErrorCode

class GuestSnapshotNotFoundException(
    detail: String? = null,
): BusinessException(
    errorCode = ErrorCode.GUEST_SNAPSHOT_NOT_FOUND,
    detail = detail,
)
